package com.example.projects.messageBuilder;

@WithBuilder
public class MessageBuilder {
    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;

    private MessageBuilder(MessageType messageType, String content, String sender, String recipient, boolean isDelivered, long timestamp) {
        this.messageType = messageType;
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.isDelivered = isDelivered;
        this.timestamp = timestamp;
    }

    private MessageBuilder(MessageBuilder.Builder builder) {
        this(
                builder.messageType,
                builder.content,
                builder.sender,
                builder.recipient,
                builder.isDelivered,
                builder.timestamp
        );
    }

    public static class Builder {
        private MessageType messageType;
        private String content;
        private String sender;
        private String recipient;
        private boolean isDelivered;
        private long timestamp;

        public MessageBuilder.Builder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageBuilder.Builder content(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder.Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public MessageBuilder.Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public MessageBuilder.Builder isDelivered(boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public MessageBuilder.Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public MessageBuilder build() {
            return new MessageBuilder(this);
        }
    }


}