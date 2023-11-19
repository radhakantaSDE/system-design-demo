package com.learn.app.consumer;

public class ConsumerImpl implements Consumer {

    private final String consumerKey;

    public ConsumerImpl(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    @Override
    public String consumerKey() {
        return this.consumerKey;
    }

    @Override
    public Class<?> payloadType() {
        return String.class;
    }
}
