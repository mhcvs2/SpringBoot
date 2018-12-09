package com.mhc.springboot_retry;

import com.mhc.springboot_retry.exceptions.MhcException2;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class DoSomething {

    @Retryable(value = {MhcException2.class}, maxAttempts = 5, backoff = @Backoff(value = 500L))
    public void execute(int a) throws MhcException2 {
        System.out.println("DoSomething get " + a);
        if(a < 0) {
            throw new MhcException2("fu de");
        }
    }

}
