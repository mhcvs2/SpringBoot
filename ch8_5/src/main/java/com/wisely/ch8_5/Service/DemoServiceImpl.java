package com.wisely.ch8_5.Service;

import com.wisely.ch8_5.dao.PersonRepository;
import com.wisely.ch8_5.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key="#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id/key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id/key为" + id + "的数据缓存");
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findById(person.getId()).orElse(null);
        System.out.println("为id/key为: " + p.getId() + "数据做了缓存");
        return p;
    }
}
