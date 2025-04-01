package com.streamingService.stream_client;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);

    private String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        log.info("{} subscribed");
        subscription.request(Integer.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} onNext: ", item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error: ", throwable);
    }

    @Override
    public void onComplete() {
        log.info("completed");
    }
}
