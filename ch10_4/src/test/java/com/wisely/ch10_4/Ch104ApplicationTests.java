package com.wisely.ch10_4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisely.ch10_4.dao.PersonRepository;
import com.wisely.ch10_4.domain.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class Ch104ApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    String expectedJson;

    @Before
    public void setUp() throws JsonProcessingException {
        Person p1 = new Person("wyf");
        Person p2 = new Person("wisely");
        personRepository.save(p1);
        personRepository.save(p2);
        expectedJson = Obj2Json(personRepository.findAll());
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String Obj2Json(Object obj) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void testPersonController() throws Exception {
        String uri = "/person";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("错误, 正确的返回值为200", 200, status);
        Assert.assertEquals("错误, 返回值和与其返回值不一致", expectedJson, content);
    }

}
