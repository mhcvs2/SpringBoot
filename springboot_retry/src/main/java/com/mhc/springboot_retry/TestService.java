package com.mhc.springboot_retry;

import com.mhc.springboot_retry.exceptions.MhcException1;
import com.mhc.springboot_retry.exceptions.MhcException2;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    DoSomething doSomething;

    @Retryable(value = {MhcException1.class}, maxAttempts = 5, backoff = @Backoff(value = 500L))
    //backoff 是间隔毫秒数
    //maxAttempts 重试次数
    public void test1(int a) throws MhcException1 {
        System.out.println("test1 get " + a);
        if(a < 0) {
            throw new MhcException1("fu de");
        }
    }

    @Recover
    public void recover(MhcException1 exception1) {
        System.out.println("recover" + exception1.toString());
    }

    public void test2(int a) {
        try {
            doSomething.execute(a);
        } catch (MhcException2 exception2) {
            exception2.printStackTrace();
        }

    }

    //本类中调用，必须通过代理，因为retry使用了aop增强
    //要获取代理，要加@EnableAspectJAutoProxy(exposeProxy = true)，将代理设为thread local
    public void test3(int a) throws MhcException1 {
        ((TestService) AopContext.currentProxy()).test1(a);
    }

}
