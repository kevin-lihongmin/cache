package com.kevin.cache.redisson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *  Spring Bean 工具类（静态获取）
 * @author kevin
 * @date 2020/9/15 17:41
 * @since 1.0.0
 */
@Component
public class BeanTools implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> beanClass) {
        try {
            return applicationContext.getBean(beanClass);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object getBean(String beanName) {
        try {
            return applicationContext.getBean(beanName);
        } catch (Exception e) {
            return null;
        }
    }
}
