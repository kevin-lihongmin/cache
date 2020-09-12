package com.kevin.cache.batch;

import com.kevin.cache.CacheApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  测试批量获取
 * @author kevin
 * @date 2020/9/12 16:06
 * @since 1.0.0
 *
 * 2020-09-12 21:30:44.103  INFO 8676 --- [           main] com.kevin.cache.batch.TestBatch          : result size = 1000
 * 2020-09-12 21:30:44.104  INFO 8676 --- [           main] com.kevin.cache.batch.TestBatch          : StopWatch 'testBatch': running time = 28018301 ns
 * ---------------------------------------------
 * ns         %     Task name
 * ---------------------------------------------
 * 000329401  001%  ready
 * 027688900  099%  get result
 *
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class TestBatch {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String prefix = "product:";

    private Product createProduct(Long num) {
        Product product = new Product();
        product.setId(num);
        product.setName("name123" + num);
        product.setProductInfo1("setProductInfo1setProductInfo1" + num);
        product.setProductInfo2("setProductInfo2setProductInfo2" + num);
        product.setProductInfo3("setProductInfo3setProductInfo3" + num);
        product.setProductInfo4("setProductInfo4setProductInfo4" + num);
        product.setProductInfo5("setProductInfo5setProductInfo5" + num);
        product.setProductInfo6("setProductInfo6setProductInfo6" + num);
        product.setProductInfo7("setProductInfo7setProductInfo7" + num);
        product.setProductInfo8("setProductInfo8setProductInfo8" + num);
        product.setProductInfo9("setProductInfo9setProductInfo9" + num);
        product.setProductInfo10("setProductInfo10setProductInfo10" + num);
        product.setProductInfo11("setProductInfo11setProductInfo11" + num);
        product.setProductInfo12("setProductInfo12setProductInfo12" + num);
        product.setProductInfo13("setProductInfo13setProductInfo13" + num);
        product.setProductInfo14("setProductInfo14setProductInfo14" + num);
        product.setProductInfo14("setProductInfo14setProductInfo14" + num);
        product.setProductInfo16("setProductInfo16setProductInfo16" + num);
        product.setProductInfo17("setProductInfo17setProductInfo17" + num);
        product.setProductInfo18("setProductInfo18setProductInfo18" + num);


        return product;
    }

    /**
     * 添加数据
     */
    @Test
    public void testBatchBefore() {
        /*redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setStringSerializer(new GenericJackson2JsonRedisSerializer());*/
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        ValueOperations valueOperations = redisTemplate.opsForValue();
        for (long i= 1; i < 10000000; i ++) {
            Product product = createProduct(i);
            valueOperations.set(prefix + i,product);
            log.info("save" + i);
        }

        stopwatch.stop();
        stopwatch.prettyPrint();
    }

    @Test
    public void testBatch() {
        StopWatch stopwatch = new StopWatch("testBatch");
        stopwatch.start("ready");

        ValueOperations valueOperations = redisTemplate.opsForValue();

        Random random = new Random(120000);

        ArrayList<String> arrayList = new ArrayList();
        for (long i= 0; i < 1000; i ++) {
            arrayList.add(prefix + random.nextInt());
        }
        stopwatch.stop();
        stopwatch.start("get result");
        List list = valueOperations.multiGet(arrayList);
        stopwatch.stop();
        log.info("result size = {}", list == null ? 0 : list.size());
        log.info(stopwatch.prettyPrint());
    }

}
