package com.mhc.springbootredis.common.lock.redisson;

import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

public class RedissonUtil {

    private static RedissonDistributedLocker redissLock;
    private static Integer releaseTimeout;

    public static void setLocker(RedissonDistributedLocker locker) {
        redissLock = locker;
    }

    public static void setReleaseTimeout(Integer releaseTimeout) {
        RedissonUtil.releaseTimeout = releaseTimeout;
    }

    /**
     * 加锁
     * @param lockKey
     * @return
     */
    public static RLock lock(String lockKey) {
        return redissLock.lock(lockKey);
    }

    /**
     * 释放锁
     * @param lockKey
     */
    public static void unlock(String lockKey) {
        redissLock.unlock(lockKey);
    }

    /**
     * 释放锁
     * @param lock
     */
    public static void unlock(RLock lock) {
        redissLock.unlock(lock);
    }

    /**
     * 带超时的锁
     * @param lockKey
     */
    public static RLock lockByTimeout(String lockKey) {
        return redissLock.lock(lockKey, releaseTimeout);
    }

    /**
     * 带超时的锁
     * @param lockKey
     * @param unit 时间单位
     * @param timeout 超时时间
     */
    public static RLock lock(String lockKey, TimeUnit unit , int timeout) {
        return redissLock.lock(lockKey, unit, timeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey
     * @param waitTime 最多等待时间
     * @return
     */
    public static boolean tryLockByTimeout(String lockKey, int waitTime) {
        return redissLock.tryLock(lockKey, TimeUnit.SECONDS, waitTime, releaseTimeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey
     * @param unit 时间单位
     * @param waitTime 最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public static boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        return redissLock.tryLock(lockKey, unit, waitTime, leaseTime);
    }

}
