package com.mhc.mybatis2;

import com.mhc.mybatis2.mapper.UserMapper;
import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.service.OtherService;
import com.mhc.mybatis2.service.UserService;
import com.mhc.mybatis2.utils.SomeUtils;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@SpringBootTest
@PowerMockRunnerDelegate(value = SpringJUnit4ClassRunner.class)
@PowerMockIgnore(value = {"javax.management.*", "javax.net.ssl.*", "javax.net.*"})
@PrepareForTest(value = {SomeUtils.class})
public class Mybatis2ApplicationTests5 {

    @Test
    public void testOne() throws Exception {
        PowerMock.mockStatic(SomeUtils.class);
        EasyMock.expect(SomeUtils.exec(EasyMock.anyString())).andStubReturn("bala");

        PowerMock.replay(SomeUtils.class);

        System.out.println(SomeUtils.exec("dddd"));

    }

    @Test
    public void test2() throws Exception {
        PowerMock.mockStatic(SomeUtils.class);

        SomeUtils.exec2(EasyMock.anyString());
        SomeUtils.exec2(EasyMock.anyString());
//        PowerMock.expectLastCall();

        PowerMock.replay(SomeUtils.class);
        SomeUtils.exec2("dddddfsdf");
//        SomeUtils.exec2("ddddaaaaa");
    }

}
