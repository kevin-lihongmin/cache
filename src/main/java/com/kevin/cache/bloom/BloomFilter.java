package com.kevin.cache.bloom;


import io.rebloom.client.Client;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  Redis 布隆过滤器
 * @author kevin
 * @date 2020/8/22 2:03
 * @since 1.0.0
 */
public class BloomFilter {

    public static void main(String[] args) {
        Client client = new Client("192.168.1.108", 6379);

        Random random = new Random(100000000000000L);

        for (int i = 0; i < 1000000000; i++) {
            client.add("kevin", "kevin" + random.nextLong());
            System.out.println(i);
        }

        boolean exists = client.exists("kevin", "kevin9278957353095593");
        System.out.println(exists);
    }
}
