package com.mhc.springbootredis.common.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public interface DistributedLocker<T extends Lock> {

    T lock(String lockKey);

    T lock(String lockKey, int timeout);

    T lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(T lock);

    boolean tryLock(String lockKey);

}
