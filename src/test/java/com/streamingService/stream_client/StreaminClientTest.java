package com.streamingService.stream_client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes=StreaminClientTest.class)
public class StreaminClientTest {
    

    private static StreamingService client;
    private static final String URL = "https://playback.sportradar.com/subscribe/statistics?recording_id=9b90d270-f055-11ee-8a1c-85b768d10d0b";

    @BeforeEach
    private void createService() {
        client = new StreamingService();
    }

    @Test
    private void verifyStream() {
        var streamedData = client.streamData(URL)
            .subscribe();
            streamedData.toString();
        Assert.isNull(streamedData.toString(), "Value must not be null");
    }
}
