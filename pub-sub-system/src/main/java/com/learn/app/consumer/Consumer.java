package com.learn.app.consumer;

public interface Consumer {
    String consumerKey();
    Class<?> payloadType();
}
