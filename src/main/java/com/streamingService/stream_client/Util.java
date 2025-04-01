package com.streamingService.stream_client;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);
    
    public static <T>DefaultSubscriber<T> subscribe(String name) {
        return new DefaultSubscriber<>(name);
    }

    public static void sleep(long length) {
        try {
            Thread.sleep(Duration.ofSeconds(length));
        } catch (InterruptedException e) {
           log.error("oops from Utils", e);
        }
    }
}
