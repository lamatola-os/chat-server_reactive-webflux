package com.chat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
//@EnableWebFlux
//@EnableScheduling
public class ChatApplication {

    public static final int N_WORKER_THREADS = Runtime.getRuntime().availableProcessors() * 2;

    @Bean
    public Scheduler ioScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(N_WORKER_THREADS));
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }
}
