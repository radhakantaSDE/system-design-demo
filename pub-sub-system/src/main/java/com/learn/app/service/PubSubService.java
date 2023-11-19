package com.learn.app.service;

import com.learn.app.consumer.Consumer;
import com.learn.app.data.Message;

public interface PubSubService {

    boolean registerConsumer(String topic, Consumer consumer);
    boolean sendMessage(String topic, Message<?> message);
}
