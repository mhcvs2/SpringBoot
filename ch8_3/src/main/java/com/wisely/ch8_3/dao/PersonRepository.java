package com.wisely.ch8_3.dao;

import com.wisely.ch8_3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

    @RestResource(path = "nameStartswith", rel = "nameStartswith")
    Person findByNameStartsWith(@Param("name")String name);

}
