package com.chat.server.client;

import org.glassfish.jersey.internal.jsr166.Flow;
import reactor.netty.http.client.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class ChatClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget chatService = client.target("http://localhost:8080/v2/chat");

        chatService.request()
                .accept(MediaType.APPLICATION_JSON) //FIXME should be text/stream in this example
                .rx()
                .get(new GenericType<List<ChatResponse>>() {})
                .thenAcceptAsync(response -> {
                    System.out.println("final response: " + response);
                })
                .exceptionally((throwable) -> {
                    System.out.println("Error " + throwable);
                    return null;
                });

//        System.setProperty("io.netty.tryReflectionSetAccessible", "false");

//https://github.com/reactor/reactor-netty
//        HttpClient
//                .create()
//                .baseUrl("localhost")
//                .port(8080)
//                .get()
//                .uri("/v2/chat")
//                .response()
//                .doOnSubscribe(a -> a.request(10))
//                .doOnNext(a -> System.out.println(a.currentContext()));
    }

}
