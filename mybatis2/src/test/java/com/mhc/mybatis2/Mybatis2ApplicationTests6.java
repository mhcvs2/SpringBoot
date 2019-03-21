package com.mhc.mybatis2;

import com.alibaba.fastjson.JSON;
import com.mhc.mybatis2.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Rollback
@Transactional(transactionManager = "transactionManager")
public class Mybatis2ApplicationTests6 {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testOne() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        user.setUserId(1);
        String data = JSON.toJSONString(user);
        System.out.println(data);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .contentType(MediaType.APPLICATION_JSON)
        .content(data))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        System.out.println(content);
    }

}
