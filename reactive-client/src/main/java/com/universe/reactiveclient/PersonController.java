package com.universe.reactiveclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private PersonClient personClient;

    @Autowired
    public PersonController (PersonClient personClient) {
        this.personClient = personClient;
    }

    @GetMapping("/{gender}/{amount}")
    public Flux<Person> genderSalary(@PathVariable("gender") String gender, @PathVariable("amount") int amount) {
        return personClient.getPeople()
                .filter(person -> gender.equals(person.gender))
                .filter(person -> amount < Float.valueOf(person.salary));
    }

    @GetMapping("/{gender}/{amount}/count")
    public Mono<Long> genderSalaryCount(@PathVariable("gender") String gender, @PathVariable("amount") int amount) {
        return this.genderSalary(gender, amount)
                .count();
    }
}
