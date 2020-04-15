package com.chat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@SpringBootApplication
//@EnableWebFlux
//@EnableScheduling
public class Application {

    @Bean
    public Scheduler ioScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
