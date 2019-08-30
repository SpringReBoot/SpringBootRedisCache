package com.springreboot.cache.redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements ICacheService {

	@Cacheable(cacheNames = {"cache1"})
	@Override
	public Double doComplexCalculation(Double value) {
		
		// Fake slow performance for complex calculation
		try {
			Thread.sleep( 10*1000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Double.MAX_VALUE;
	}

}
