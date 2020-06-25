// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.query;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.implementation.BadRequestException;
import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.Resource;
import com.azure.cosmos.implementation.query.aggregation.AggregateOperator;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.implementation.JsonSerializable;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.fasterxml.jackson.databind.node.ObjectNode;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class GroupByDocumentQueryExecutionContext<T extends Resource> implements
    IDocumentQueryExecutionComponent<T> {

    public static final String CONTINUATION_TOKEN_NOT_SUPPORTED_WITH_GROUP_BY = "Continuation token is not supported " +
                                                                                    "for queries with GROUP BY." +
                                                                                    "Do not use continuation token" +
                                                                                    " or remove the GROUP BY " +
                                                                                    "from the query.";
    private final IDocumentQueryExecutionComponent<T> component;
    private final GroupingTable groupingTable;

    GroupByDocumentQueryExecutionContext(
        IDocumentQueryExecutionComponent<T> component,
        GroupingTable groupingTable) {
        this.component = component;
        this.groupingTable = groupingTable;
    }

    public static <T extends Resource> Flux<IDocumentQueryExecutionComponent<T>> createAsync(
        Function<String, Flux<IDocumentQueryExecutionComponent<T>>> createSourceComponentFunction,
        String continuationToken,
        Map<String, AggregateOperator> groupByAliasToAggregateType,
        List<String> orderedAliases,
        boolean hasSelectValue) {
        if (continuationToken != null) {
            CosmosException dce = new BadRequestException(CONTINUATION_TOKEN_NOT_SUPPORTED_WITH_GROUP_BY);
            return Flux.error(dce);
        }
        if (groupByAliasToAggregateType == null) {
            throw new IllegalArgumentException("groupByAliasToAggregateType should not be null");
        }
        if (orderedAliases == null) {
            throw new IllegalArgumentException("orderedAliases should not be null");
        }
        GroupingTable table = new GroupingTable(groupByAliasToAggregateType, orderedAliases, hasSelectValue);
        // Have to pass non-null continuation token once supported
        return createSourceComponentFunction.apply(null)
                   .map(component -> new GroupByDocumentQueryExecutionContext<>(component,
                                                                                table));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Flux<FeedResponse<T>> drainAsync(int maxPageSize) {
        return this.component.drainAsync(maxPageSize)
                   .collectList()
                   .map(superList -> {
                       double requestCharge = 0;
                       HashMap<String, String> headers = new HashMap<>();
                       List<Document> documentList = new ArrayList<>();
                       /* Do groupby stuff here */
                       // Stage 1:
                       // Drain the groupings fully from all continuation and all partitions
                       for (FeedResponse<T> page : superList) {
                           List<Document> results = (List<Document>) page.getResults();
                           documentList.addAll(results);
                       }

                       this.aggregateGroupings(documentList);

                       // Stage 2:
                       // Emit the results from the grouping table page by page

                       List<Document> groupByResults = this.groupingTable.drain(maxPageSize);

                       headers.put(HttpConstants.HttpHeaders.REQUEST_CHARGE, Double.toString(requestCharge));
                       FeedResponse<Document> frp =
                           BridgeInternal.createFeedResponse(groupByResults, headers);

                       return (FeedResponse<T>) frp;
                   }).flux();
    }

    private void aggregateGroupings(List<Document> superList) {
        for (Document d : superList) {
            RewrittenGroupByProjection rewrittenGroupByProjection =
                new RewrittenGroupByProjection(ModelBridgeInternal.getPropertyBagFromJsonSerializable(d));
            this.groupingTable.addPayLoad(rewrittenGroupByProjection);
        }
    }

    IDocumentQueryExecutionComponent<T> getComponent() {
        return this.component;
    }

    /**
     * When a group by query gets rewritten the projection looks like:
     * <p>
     * SELECT
     * [{"item": c.age}, {"item": c.name}] AS groupByItems,
     * {"age": c.age, "name": c.name} AS payload
     * <p>
     * This class just lets us easily access the "groupByItems" and "payload" property.
     */
    public class RewrittenGroupByProjection extends JsonSerializable {
        private static final String GROUP_BY_ITEMS_PROPERTY_NAME = "groupByItems";
        private static final String PAYLOAD_PROPERTY_NAME = "payload";

        private List<Document> groupByItems;

        public RewrittenGroupByProjection(ObjectNode objectNode) {
            super(objectNode);
            if (objectNode == null) {
                throw new IllegalArgumentException("objectNode can not be null");
            }
        }

        /**
         * Getter for property 'groupByItems'.
         *
         * @return Value for property 'groupByItems'.
         */
        public List<Document> getGroupByItems() {
            groupByItems = this.getList(GROUP_BY_ITEMS_PROPERTY_NAME, Document.class);
            if (groupByItems == null) {
                throw new IllegalStateException("Underlying object does not have an 'groupByItems' field.");
            }
            return groupByItems;
        }

        /**
         * Getter for property 'payload'.
         *
         * @return Value for property 'payload'.
         */
        public Document getPayload() {
            if (!this.has(PAYLOAD_PROPERTY_NAME)) {
                throw new IllegalStateException("Underlying object does not have an 'payload' field.");
            }

            return new Document((ObjectNode) this.get(PAYLOAD_PROPERTY_NAME));
        }
    }
}
