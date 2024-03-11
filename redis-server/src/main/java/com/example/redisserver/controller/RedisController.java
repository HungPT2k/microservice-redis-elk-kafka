package com.example.redisserver.controller;

import com.example.redisserver.Cache.cacheManagers;
import com.example.redisserver.Object.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/redis-cache/")
public class RedisController {
    @Autowired
    private cacheManagers cacheManager;
    @PostMapping("/read")
    @Cacheable(cacheNames = "product",key = "#p.id")
    public String readCache(@RequestBody product p){
        return p.toString();
    }

    @GetMapping("/get/")
    public String getValueByKey(@RequestParam(name = "cacheName") String cacheName, @RequestParam(name = "key") String key){
      Object o=  cacheManager.getValueFromCache(cacheName,key);
            if(o==null) return null;
        return o.toString();
    }
}
