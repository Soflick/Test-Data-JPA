package ru.loginov.denis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loginov.denis.models.Person;

public interface PeoplePerository extends JpaRepository<Person,Integer> {
}
