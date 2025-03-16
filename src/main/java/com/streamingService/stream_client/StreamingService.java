package com.streamingService.stream_client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

public class StreamingService {
    private static final Logger log = LoggerFactory.getLogger(StreamingService.class);
    private WebClient client =  WebClient.builder().build();

    public Flux<Object> streamData(String url) {
        log.info("Streaming data from {}", url);
        return client.get()
        .uri(url)
        .exchangeToFlux(response -> {
            if(response.statusCode().is2xxSuccessful()) {
                return response.bodyToFlux(String.class);
            }else {
                return response.createError().flux();
            }
        });
    }

    private void closeClient() {
        
    }
}
