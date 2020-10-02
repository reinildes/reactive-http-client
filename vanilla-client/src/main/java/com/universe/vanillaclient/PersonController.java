package com.universe.vanillaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Person> genderSalary(@PathVariable("gender") String gender, @PathVariable("amount") int amount) {
        return personClient.getPeople().stream()
                .filter(person -> gender.equals(person.gender))
                .filter(person -> amount < Float.valueOf(person.salary))
                .collect(Collectors.toList());
    }

    @GetMapping("/{gender}/{amount}/count")
    public long genderSalaryCount(@PathVariable("gender") String gender, @PathVariable("amount") int amount) {
        return this.genderSalary(gender, amount).stream()
                .count();
    }
}
