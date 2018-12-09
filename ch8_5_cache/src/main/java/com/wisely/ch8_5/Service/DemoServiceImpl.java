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

//@Caching注解可以让我们在一个方法或者类上同时指定多个Spring Cache相关的注解。其拥有三个属性：cacheable、put和evict，分别用于指定@Cacheable、@CachePut和@CacheEvict。
//
//@Caching(cacheable = @Cacheable("users"), evict = { @CacheEvict("cache2"),
//
//        @CacheEvict(value = "cache3", allEntries = true) })
//
//public User find(Integer id) {
//
//        returnnull;
//
//        }