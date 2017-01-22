package com.muatik;

import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mustafaatik on 20/01/17.
 */
@Configuration
public class CacheConfig {

    @Bean
    public ConcurrentMapCache concurrentMapCache() {
        return new ConcurrentMapCache("entities");
    }
}
