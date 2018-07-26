package com.wisely.ch10_4.dao;

import com.wisely.ch10_4.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
