package com.universe.vanillaclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonClient {

    public List<Person> getPeople() {

        RestTemplate restTemplate = new RestTemplate();
        final Person[] people = restTemplate.getForObject("http://localhost:3000", Person[].class);

        return Arrays.asList(people);
    }
}
