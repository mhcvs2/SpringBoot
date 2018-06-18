package com.mhc.spring_cloud.example.person.dao;

import com.mhc.spring_cloud.example.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
