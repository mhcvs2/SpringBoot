package com.wisely.ch8_2.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery", query = "select p from Person p where p.name=?1 and address=?2")
public class Person {

    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate by db
    private Long id;
    private String name;
    private Integer age;
    private String address;

    public Person(){
        super();
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
