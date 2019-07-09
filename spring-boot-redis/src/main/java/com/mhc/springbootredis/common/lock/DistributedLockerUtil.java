package com.mhc.springbootredis.common.lock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class DistributedLockerUtil {

    private static DistributedLocker distributedLocker;
    private static Integer releaseTimeout;

    public static void setLocker(DistributedLocker locker) {
        distributedLocker = locker;
    }

    public static void setReleaseTimeout(Integer releaseTimeout) {
        DistributedLockerUtil.releaseTimeout = releaseTimeout;
    }

    /**
     * 加锁
     * @param lockKey
     * @return
     */
    public static <T extends Lock> T lock(String lockKey) {
        return (T)distributedLocker.lock(lockKey);
    }

    /**
     * 释放锁
     * @param lockKey
     */
    public static void unlock(String lockKey) {
        distributedLocker.unlock(lockKey);
    }

    /**
     * 释放锁
     * @param lock
     */
    public static <T extends Lock> void unlock(T lock) {
        distributedLocker.unlock(lock);
    }

    /**
     * 带超时的锁
     * @param lockKey
     */
    public static <T extends Lock> T lockByTimeout(String lockKey) {
        return (T)distributedLocker.lock(lockKey, releaseTimeout);
    }

    /**
     * 带超时的锁
     * @param lockKey
     * @param unit 时间单位
     * @param timeout 超时时间
     */
    public static <T extends Lock> T lock(String lockKey, TimeUnit unit , int timeout) {
        return (T)distributedLocker.lock(lockKey, unit, timeout);
    }

    /**
     * 尝试获取锁
     * @param lockKey
     * @param waitTime 最多等待时间
     * @return
     */
    public static boolean tryLockByTimeout(String lockKey, int waitTime) {
        return distributedLocker.tryLock(lockKey, TimeUnit.SECONDS, waitTime, releaseTimeout);
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
        return distributedLocker.tryLock(lockKey, unit, waitTime, leaseTime);
    }

    public static boolean tryLock(String lockKey) {
        return distributedLocker.tryLock(lockKey);
    }

}
