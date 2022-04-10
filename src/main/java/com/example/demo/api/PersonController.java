package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;
import com.example.demo.service.PersonSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    
    private final PersonSevice personSevice;

    @Autowired
    public PersonController(PersonSevice personSevice) {
        this.personSevice = personSevice;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personSevice.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personSevice.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personSevice.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personSevice.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personSevice.updatePerson(id, personToUpdate);
    }

}
