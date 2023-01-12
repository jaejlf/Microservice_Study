package com.example.common.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "user", url = "http://localhost:9000")
public interface UserClient {

    @GetMapping("/user")
    UserResponse getUser(@RequestHeader("userId") Long userId) ;

}
