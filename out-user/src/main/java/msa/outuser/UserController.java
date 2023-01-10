package msa.outuser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/new/{name}")
    public User createUser(@PathVariable String name) {
        return userRepository.save(new User(name));
    }

    @GetMapping
    public User getUser(@RequestHeader("userId") Long userId) {
        return userRepository.findById(userId)
                .orElse(new User("유저 없음!"));
    }

}
