package com.springreboot.cache.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreboot.cache.redis.service.ICacheService;

@CrossOrigin
@RestController
@RequestMapping(path = "/springreboot/cache")
public class ApiController {

	@Autowired
	ICacheService cacheService;
	
	@GetMapping( path = {"/v1/redis"})
	public Double complexCalculation() {
	
		return cacheService.doComplexCalculation(Double.MIN_NORMAL);
	}
}
