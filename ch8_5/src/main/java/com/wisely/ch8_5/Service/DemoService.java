package com.wisely.ch8_5.Service;

import com.wisely.ch8_5.domain.Person;

public interface DemoService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);

}
