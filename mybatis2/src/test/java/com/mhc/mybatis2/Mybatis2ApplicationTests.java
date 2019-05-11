package com.mhc.mybatis2;

import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.service.UserService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mybatis2ApplicationTests {

    @Autowired
    UserService userService;

    @BeforeClass
    public static void before() {
        System.out.println("before class");
    }

    @Test
    public void testOne(){
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        userService.addUser(user);
        User user2 = userService.getByName("test");
        TestCase.assertEquals(user2.getPhone(), "123");
        System.out.println(user2.toString());

    }

//    @Test
//    public void testTwo(){
//        System.out.println("test hello 2");
//        TestCase.assertEquals(1, 1);
//    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }

}
