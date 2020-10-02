package com.universe.reactiveclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonClient {

    public Flux<Person> getPeople() {

        final var client = WebClient.builder().build();

        return client.get()
                .uri("http://localhost:3000")
                .retrieve()
                .bodyToFlux(Person.class);
    }
}
