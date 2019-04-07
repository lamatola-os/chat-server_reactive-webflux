package com.chat.server.client;

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
                .accept(MediaType.APPLICATION_JSON)
                .rx()
                .get(new GenericType<List<ChatResponse>>() {})
                .thenAcceptAsync(response -> {
                    System.out.println("final response: " + response);
                })
                .exceptionally((throwable) -> {
                    System.out.println("Error " + throwable);
                    return null;
                });
    }

}
