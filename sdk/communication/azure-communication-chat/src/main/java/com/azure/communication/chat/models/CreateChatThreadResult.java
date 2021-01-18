// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.chat.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The CreateChatThreadResult model. */
@Fluent
public final class CreateChatThreadResult {
    /*
     * The thread property.
     */
<<<<<<< HEAD
    @JsonProperty(value = "thread")
    private ChatThread thread;
=======
    @JsonProperty(value = "chatThread")
    private ChatThread chatThread;
>>>>>>> 3607e737b627a7840215e6eca6be23ee44780441

    /*
     * The errors property.
     */
    @JsonProperty(value = "errors")
    private CreateChatThreadErrors errors;

    /**
<<<<<<< HEAD
     * Get the thread property: The thread property.
     *
     * @return the thread value.
     */
    public ChatThread getThread() {
        return this.thread;
    }

    /**
     * Set the thread property: The thread property.
     *
     * @param thread the thread value to set.
     * @return the CreateChatThreadResult object itself.
     */
    public CreateChatThreadResult setThread(ChatThread thread) {
        this.thread = thread;
=======
     * Get the chatThread property: The chatThread property.
     *
     * @return the chatThread value.
     */
    public ChatThread getChatThread() {
        return this.chatThread;
    }

    /**
     * Set the chatThread property: The chatThread property.
     *
     * @param chatThread the thread value to set.
     * @return the CreateChatThreadResult object itself.
     */
    public CreateChatThreadResult setChatThread(ChatThread chatThread) {
        this.chatThread = chatThread;
>>>>>>> 3607e737b627a7840215e6eca6be23ee44780441
        return this;
    }

    /**
     * Get the errors property: The errors property.
     *
     * @return the errors value.
     */
    public CreateChatThreadErrors getErrors() {
        return this.errors;
    }

    /**
     * Set the errors property: The errors property.
     *
     * @param errors the errors value to set.
     * @return the CreateChatThreadResult object itself.
     */
    public CreateChatThreadResult setErrors(CreateChatThreadErrors errors) {
        this.errors = errors;
        return this;
    }
}
