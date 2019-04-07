package com.chat.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@Configuration
//public class ChatServerRoutes {
//
//    @Bean
//    public RouterFunction<ServerResponse> route(ChatServer chatServer) {
//
//        return RouterFunctions
//                .route(
//                        RequestPredicates
//                                .GET("/chat")
//                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//                        chatServer::chat
//                );
//    }
//}
