package com.kevin.cache.redisson;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.kevin.cache.redisson.DistributedLockUtil.CacheConfig.PRE_SELL;
import static com.kevin.cache.redisson.DistributedLockUtil.invokeInLock;

/**
 *  测试redisson 获取批量的 分布式锁
 * @author kevin
 * @date 2020/9/15 17:44
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        String[] lockKey = new String[2];

        final Boolean aBoolean = invokeInLock(Test::createVsoInLock, PRE_SELL, lockKey);
        System.out.println(aBoolean);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public static Boolean createVsoInLock() {
        // 在锁中执行的任务
        return true;
    }
}
