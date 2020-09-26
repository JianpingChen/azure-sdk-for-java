// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/** The MetricDataQueryOptions model. */
@Fluent
public final class MetricDataQueryOptions {
    /*
     * start time of query a time series data, and format should be
     * yyyy-MM-ddThh:mm:ssZ
     */
    @JsonProperty(value = "startTime", required = true)
    private OffsetDateTime startTime;

    /*
     * start time of query a time series data, and format should be
     * yyyy-MM-ddThh:mm:ssZ
     */
    @JsonProperty(value = "endTime", required = true)
    private OffsetDateTime endTime;

    /*
     * query specific series
     */
    @JsonProperty(value = "series", required = true)
    private List<Map<String, String>> series;

    /**
     * Get the startTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     *
     * @return the startTime value.
     */
    public OffsetDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     *
     * @param startTime the startTime value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    public MetricDataQueryOptions setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     *
     * @return the endTime value.
     */
    public OffsetDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Set the endTime property: start time of query a time series data, and format should be yyyy-MM-ddThh:mm:ssZ.
     *
     * @param endTime the endTime value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    public MetricDataQueryOptions setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the series property: query specific series.
     *
     * @return the series value.
     */
    public List<Map<String, String>> getSeries() {
        return this.series;
    }

    /**
     * Set the series property: query specific series.
     *
     * @param series the series value to set.
     * @return the MetricDataQueryOptions object itself.
     */
    public MetricDataQueryOptions setSeries(List<Map<String, String>> series) {
        this.series = series;
        return this;
    }
}