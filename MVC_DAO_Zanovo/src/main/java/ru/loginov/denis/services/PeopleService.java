package ru.loginov.denis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.loginov.denis.models.Person;
import ru.loginov.denis.repositories.PeoplePerository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeoplePerository peoplePerository;
    @Autowired
    public PeopleService(PeoplePerository peoplePerository) {
        this.peoplePerository = peoplePerository;
    }

    public List<Person> findAll(){
        return peoplePerository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = peoplePerository.findById(id);
        return  foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person){
        peoplePerository.save(person);
    }
    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peoplePerository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peoplePerository.deleteById(id);
    }
}
