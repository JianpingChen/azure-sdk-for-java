// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.chat.implementation.converters;

import com.azure.communication.chat.models.CreateChatThreadResult;

/**
 * A converter between {@link com.azure.communication.chat.implementation.models.CreateChatThreadResult} and
 * {@link CreateChatThreadResult}.
 */
public final class CreateChatThreadResultConverter {
    /**
     * Maps from {@link com.azure.communication.chat.implementation.models.CreateChatThreadResult} to
     * {@link CreateChatThreadResult}.
     */
    public static CreateChatThreadResult convert(
        com.azure.communication.chat.implementation.models.CreateChatThreadResult obj) {

        if (obj == null) {
            return null;
        }

        CreateChatThreadResult createChatThreadResult = new CreateChatThreadResult()
<<<<<<< HEAD
            .setThread(ChatThreadConverter.convert(obj.getThread()))
=======
            .setChatThread(ChatThreadConverter.convert(obj.getChatThread()))
>>>>>>> 3607e737b627a7840215e6eca6be23ee44780441
            .setErrors(obj.getErrors());

        return createChatThreadResult;
    }

    private CreateChatThreadResultConverter() {
    }
}
