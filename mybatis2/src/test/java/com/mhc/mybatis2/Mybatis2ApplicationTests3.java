package com.mhc.mybatis2;

import com.mhc.mybatis2.mapper.UserMapper;
import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.model.UserExample;
import com.mhc.mybatis2.service.UserService;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mybatis2ApplicationTests3 {

    @Autowired
    UserService userService;

    @Test
//    @Ignore
    public void testOne() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        user.setUserId(1);
        List<User> users = new ArrayList<>();
        users.add(user);
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        EasyMock.expect(userMapper.selectByExample(EasyMock.isA(UserExample.class))).andReturn(users);
        EasyMock.replay(userMapper);

        List<User> users2 = userMapper.selectByExample(new UserExample());
        User user2 = users2.get(0);
        System.out.println(user2.toString());
//        userMapper.insert(user);   //  Unexpected method call UserMapper.insert(User{userId=1, userName='test', password='321', phone='123'}):

        EasyMock.verify(userMapper);

    }

//    @Test
//    public void test2() throws Exception {
//        User user = new User();
//        user.setUserName("test");
//        user.setPhone("123");
//        user.setPassword("321");
//        user.setUserId(1);
//        List<User> users = new ArrayList<>();
//        users.add(user);
//        //java.lang.IllegalArgumentException: Partial mocking doesn't make sense for interface
//        UserMapper userMapper = EasyMock.partialMockBuilder(UserMapper.class).addMockedMethod("selectByExample").createMock();
//        EasyMock.expect(userMapper.selectByExample(EasyMock.isA(UserExample.class))).andReturn(users);
//        EasyMock.replay(userMapper);
//
//        List<User> users2 = userMapper.selectByExample(new UserExample());
//        User user2 = users2.get(0);
//        System.out.println(user2.toString());
//        userMapper.insert(user);
//
//        EasyMock.verify(userMapper);
//    }

//    @Test
//    public void test2() throws Exception {
//        User user = new User();
//        user.setUserName("test");
//        user.setPhone("123");
//        user.setPassword("321");
//        user.setUserId(1);
////        List<User> users = new ArrayList<>();
////        users.add(user);
//        UserService userService1 = EasyMock.createMock(UserService.class);
////        EasyMock.expect(userMapper.selectByExample(EasyMock.isA(UserExample.class))).andReturn(users);
//        EasyMock.expect(userService1.getUser(EasyMock.anyObject())).andReturn(user);
//        PowerMock.expectNew(UserService.class).andReturn(userService1);
//        EasyMock.replay(userService1);
//
//        User user2 = userService.getUser(123);
//        System.out.println(user2.toString());
//
//        EasyMock.verify(userService1);
//
//    }



}
