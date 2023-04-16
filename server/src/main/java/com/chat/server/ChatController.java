package com.chat.server;

import com.chat.server.client.ChatResponse;
import com.chat.server.client.HealthResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

//@Component
//public class ChatServer {
//
//    public Mono<ServerResponse> chat(ServerRequest request) {
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(BodyInserters.fromObject("hi how can i help you?"));
//    }
//}

@RestController
@RequestMapping
class ChatController {

    private static final Logger logger = LogManager.getLogger();

    @GetMapping(
            value = "/heartbeat",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Mono<HealthResponse> getHealth() {
        logger.info("/heartbeat");
        return Mono.just(
          new HealthResponse(
                  "chat-server",
                  "1.0"
          )
        );
    }

    @GetMapping(
            value = "/v2/chat",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    Flux<ChatResponse> chatResponsePublisher() {
        return Flux.fromStream(
                Stream.of(
                        ChatResponse.builder()
                                .message("message1: hi how can i help you")
                                .build(),
                        ChatResponse.builder()
                                .message("message2: Please see the FAQ for more.")
                                .build(),
                        ChatResponse.builder()
                                .message("message3: If this does not answer your question. Talk to our rep.")
                                .build()
                )
        ).delayElements(Duration.ofSeconds(1));
    }
}
