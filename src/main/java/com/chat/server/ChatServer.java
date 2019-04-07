package com.chat.server;

import com.chat.server.client.ChatResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

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
class ChatServer {

    @GetMapping(
            value = "/v2/chat",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Flux<ChatResponse> chatResponsePublisher() {
        return Flux.fromStream(
                Stream.of(
                        ChatResponse.builder()
                                .message("hi how can i help you")
                                .build(),
                        ChatResponse.builder()
                                .message("Please see stuff")
                                .build(),
                        ChatResponse.builder()
                                .message("whatever")
                                .build()
                )
        ).delayElements(Duration.ofSeconds(1));
    }
}
