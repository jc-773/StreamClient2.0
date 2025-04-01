package com.streamingService.stream_client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StreamingService implements StreamingServiceInterface {
    private static final Logger log = LoggerFactory.getLogger(StreamingService.class);
    private WebClient client;

    public StreamingService() {
        client = WebClient.builder().build();
    }

    @Override
    public Flux<Object> streamDataFlux(String url) {
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

    @Override
    public Mono<Object> streamDataMono(String url) {
        log.info("Streaming data from {}", url);
        return client.get()
        .uri(url)
        .exchangeToMono(response -> {
            if(response.statusCode().is2xxSuccessful()) {
                return response.bodyToMono(String.class);
            }else {
                return response.createError();
            }
        });
    }

    @Override
    public void setCookies(String name, String value) {
        this.client.get().cookie(name, value);
    }
}
