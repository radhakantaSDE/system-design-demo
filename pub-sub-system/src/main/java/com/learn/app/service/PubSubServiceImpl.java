package com.learn.app.service;

import com.learn.app.consumer.Consumer;
import com.learn.app.data.Message;
import com.learn.app.util.PubSubException;
import lombok.NonNull;

import java.util.*;

public class PubSubServiceImpl implements PubSubService {

    // Each consumer should have separate message Queue
    private final Map<String, Queue<Message<?>>> consumerQueue; // <Consumer-key, consumer-queue>
    private final Map<String, Set<Consumer>> topicConsumers;    // <topic-name, consumer-list>

    public PubSubServiceImpl() {
        this.consumerQueue = new HashMap<>();
        this.topicConsumers = new HashMap<>();
    }

    @Override
    public boolean registerConsumer(String topic, Consumer consumer) {

        // Add queue w.r.t consumer to consume from
        if (!consumerQueue.containsKey(consumer.consumerKey())) {
            consumerQueue.put(consumer.consumerKey(), new LinkedList<Message<?>>());
        }else {
            throw new PubSubException("Duplicate consumer key not allowed");
        }

        // Add consumer w.r.t topic consumer
        if (topicConsumers.containsKey(topic)) {
            topicConsumers.get(topic).add(consumer);
        }else {
            Set<Consumer> consumers = new HashSet<>();
            consumers.add(consumer);
            topicConsumers.put(topic, consumers);
        }

        return Boolean.TRUE;
    }

    @Override
    public boolean sendMessage(@NonNull String topic, Message<?> message) {

        if (!topicConsumers.containsKey(topic)) {
            throw new PubSubException("Invalid topic to send message");
        }

        Set<Consumer> consumers = topicConsumers.get(topic);

        for (Consumer co : consumers) {

            // Get consumer queue
            Queue<Message<?>> queue = consumerQueue.get(co.consumerKey());
            queue.add(message);
        }
        return Boolean.TRUE;
    }
}
