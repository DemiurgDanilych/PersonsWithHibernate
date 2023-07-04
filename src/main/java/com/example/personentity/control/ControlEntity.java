package com.example.personentity.control;


import com.example.personentity.repository.PersonRepository;
import com.example.personentity.entity.Persons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControlEntity {

    private final PersonRepository personRepository;

    public ControlEntity(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List getCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List getAge(@RequestParam Integer age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }
    @GetMapping("/persons/by-nameSurname")
    public Optional<Persons> getNameSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
    @GetMapping("/persons/by-name")
    public List getNameSurname(@RequestParam String name) {
        return personRepository.findIdsNameNative(name);
    }

}
