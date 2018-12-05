package com.mhc.springboot_retry;

import com.mhc.springboot_retry.exceptions.MhcException1;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

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

}
