package chat.demo.controller;

import chat.demo.service.MongoUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mongo")
public class MongoUserController {

    private final MongoUserService mongoUserService;

    @GetMapping("/find/{name}")
    public String findMongoUser(@PathVariable String name) {
        return mongoUserService.selectUser(name);
    }

    @PostMapping("/save")
    public String saveMongoUser(@RequestParam String name, @RequestParam int age) {
        mongoUserService.saveUser(name, age);
        return mongoUserService.selectUser(name);
    }

}
