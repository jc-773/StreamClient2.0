package com.streamingService.stream_client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StreamingServiceInterface {
    public Flux<Object> streamDataFlux(String url);
    public Mono<Object> streamDataMono(String url);
    public void setCookies(String name, String value);
}
