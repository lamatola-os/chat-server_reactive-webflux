package com.chat.server.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static java.util.Collections.*;

@SpringBootApplication(scanBasePackages = { "com.chat" })
public class SpringHttpClient {

    @Bean
    WebClient reactiveClient() {
        return WebClient.create("http://localhost:8080");
    }

    @Bean
    CommandLineRunner demo(WebClient reactiveClient) {
        return args -> {
            reactiveClient.get()
                    .uri("/v2/chat")
                    .accept(MediaType.TEXT_EVENT_STREAM)
                    .retrieve()
                    .bodyToFlux(ChatResponse.class)
                    .subscribe(event -> {
                        System.out.println("stream event: " + event);
                    });
        };
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringHttpClient.class)
                .properties(singletonMap("server.port", "9090"))
                .run(args);
    }

}
