package com.kevin.cache.jsr107;


import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.OptionalFeature;
import javax.cache.expiry.*;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Map;
import java.util.Properties;

/**
 *  Jsr 107 规范主要接口
 *
 *  {@link CachingProvider} 缓存的创建，配置，获取，管理和控制多个{@link CacheManager}，一个应用可以在运行期间访问多个{@link CachingProvider}
 *  {@link CacheManager} 主要负责创建配置和获取管理，控制多个唯一命名的{@link Cache}， 这些{@link Cache} 存在于多个{@link CacheManager}的上下文中，
 *                        一个{@link CacheManager} 仅被一个{@link CachingProvider}拥有
 *  {@link Caching}
 *  {@link Cache} 是一个类似于{@link Map}的数据结构，会临时存储以Key为索引的值，一个{@link Cache} 仅被一个{@link CacheManager}所拥有
 *  {@link javax.cache.Cache.Entry} {@link Cache}的内部类，存储键值对
 *  {@link ExpiryPolicy} 缓存过期策略 -> 子类有:
 *      {@link CreatedExpiryPolicy}
 *      {@link ModifiedExpiryPolicy}
 *      {@link AccessedExpiryPolicy}
 *      {@link TouchedExpiryPolicy}
 *      {@link EternalExpiryPolicy}
 *
 * @author kevin
 * @date 2020/8/15 1:02
 * @since 1.0.0
 */
public class Jsr107Demo {

    public static void main(String[] args) {
        new CachingProvider() {
            @Override
            public CacheManager getCacheManager(URI uri, ClassLoader classLoader, Properties properties) {
                return null;
            }

            @Override
            public ClassLoader getDefaultClassLoader() {
                return null;
            }

            @Override
            public URI getDefaultURI() {
                return null;
            }

            @Override
            public Properties getDefaultProperties() {
                return null;
            }

            @Override
            public CacheManager getCacheManager(URI uri, ClassLoader classLoader) {
                return null;
            }

            @Override
            public CacheManager getCacheManager() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public void close(ClassLoader classLoader) {

            }

            @Override
            public void close(URI uri, ClassLoader classLoader) {

            }

            @Override
            public boolean isSupported(OptionalFeature optionalFeature) {
                return false;
            }
        };
    }
}
