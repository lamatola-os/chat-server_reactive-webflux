package com.chat.server;

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

    @GetMapping("/v2/chat")
    Flux<ChatResponse> chatResponsePublisher(){

        //Flux.fromStream(Stream.of(""));

        return Flux.just(
                ChatResponse.builder()
                        .message("hi how can i help you")
                        .build()
        );
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class ChatResponse {
    String message;
}
