package chat.mongo.controller;

import chat.mongo.dto.request.DummyUserRequest;
import chat.mongo.dto.response.DummyUserResponse;
import chat.mongo.service.DummyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mongo")
public class DummyUserController {

    private final DummyUserService dummyUserService;

    @PostMapping("/signup")
    public DummyUserResponse signUp(@RequestBody DummyUserRequest request) {
        return dummyUserService.signUp(request);
    }

    @GetMapping("/{userId}")
    public DummyUserResponse getUser(@PathVariable Long userId) {
        return dummyUserService.getUser(userId);
    }

}
