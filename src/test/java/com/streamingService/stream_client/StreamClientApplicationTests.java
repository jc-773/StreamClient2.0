package com.streamingService.stream_client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class StreamClientApplicationTests {

    @Mock
    private WebClient webClient;

	@Mock
	private WebClient.RequestHeadersUriSpec uriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Mock
    private ClientResponse clientResponse;

    private StreamingService streamingService;

    @BeforeEach
    void setUp() {
		this.webClient = WebClient.builder().build();
        streamingService = new StreamingService();
    }

    // @Test
    // void testStreamDataFlux_success() {
    //     String url = "http://localhost:8080/live/stock/feed/apple";
    //     List<String> mockData = List.of("event1", "event2"); //set your events (subject to change)
	// 	try {
	// 		Thread.sleep(Duration.ofSeconds(10));
	// 	} catch (InterruptedException e) {
	// 		e.printStackTrace();
	// 	}
    //     //when(webClient.get()).thenReturn(uriSpec);
    //     when(uriSpec.uri(url)).thenReturn(uriSpec);
    //     when(uriSpec.exchangeToFlux(any())).thenAnswer(invocation -> {
    //         Function<ClientResponse, Flux<Object>> func = invocation.getArgument(0);
    //         ClientResponse response = mock(ClientResponse.class);
    //         when(response.statusCode()).thenReturn(HttpStatus.OK);
    //         when(response.bodyToFlux(String.class)).thenReturn(Flux.fromIterable(mockData));
    //         return func.apply(response);
    //     });

    //     StepVerifier.create(streamingService.streamDataFlux(url))
    //         .expectNext("event1", "event2") //expect your events (subject to change)
    //         .verifyComplete();
    // }

    // @Test
    // void testStreamDataFlux_errorResponse() {
    //     String url = "https://example.com/data";

    //     when(webClient.get()).thenReturn(uriSpec);
    //     when(uriSpec.uri(url)).thenReturn(uriSpec);
    //     when(uriSpec.exchangeToFlux(any())).thenAnswer(invocation -> {
    //         Function<ClientResponse, Flux<Object>> func = invocation.getArgument(0);
    //         ClientResponse response = mock(ClientResponse.class);
    //         when(response.statusCode()).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR);
    //         when(response.createError()).thenReturn(Mono.error(new RuntimeException("Server error")));
    //         return func.apply(response);
    //     });

    //     StepVerifier.create(streamingService.streamDataFlux(url))
    //         .expectErrorMatches(throwable ->
    //             throwable instanceof RuntimeException &&
    //             throwable.getMessage().equals("Server error"))
    //         .verify();
    // }
}

