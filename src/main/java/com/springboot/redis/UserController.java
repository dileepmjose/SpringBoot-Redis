package com.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/{id}")
    public String saveUser(@PathVariable String id, @RequestBody String name) {
        redisService.save(id, name);
        return "Saved";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return redisService.get(id);
    }
}