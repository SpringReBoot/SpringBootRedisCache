package com.springreboot.cache.redis.config;

import java.time.Duration;
import java.util.Collections;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@ConditionalOnProperty( value = "spring.cache.type", matchIfMissing = true, havingValue = "redis" )
@Configuration
public class CacheConfig {

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheManager cm = RedisCacheManager.builder(connectionFactory)
				.cacheDefaults(defaultCacheConfig())
				.withInitialCacheConfigurations(Collections.singletonMap("predefined", defaultCacheConfig().disableCachingNullValues()))
				.transactionAware().build();
		return cm;
	}

	private RedisCacheConfiguration defaultCacheConfig() {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(100))
				.disableCachingNullValues();
		return config;
	}
}
