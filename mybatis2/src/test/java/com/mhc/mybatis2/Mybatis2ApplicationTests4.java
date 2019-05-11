package com.mhc.mybatis2;

import com.mhc.mybatis2.mapper.UserMapper;
import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.model.UserExample;
import com.mhc.mybatis2.service.OtherService;
import com.mhc.mybatis2.service.UserService;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mybatis2ApplicationTests4 {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Mock
    private OtherService otherService;

    @Test
    public void testOne() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userMapper.selectByExample(any())).thenReturn(userList);

        User user1 = userService.getUser(123);
        System.out.println(user1.toString());
        userService.addUser(user1);

    }

    @Test
    public void test2() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        when(otherService.getUser(anyInt())).thenReturn(user);

        User user1 = otherService.getUser(123);
        System.out.println(user1.toString());
        userService.addUser(user1);

    }

    @Test
    public void test3() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPhone("123");
        user.setPassword("321");
        when(otherService.getUser(anyInt())).thenReturn(user);

        User user1 = userService.getUser2(123);
        System.out.println(user1.toString());
    }


}
