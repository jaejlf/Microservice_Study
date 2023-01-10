package msa.outuser;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/new")
    public User createUser(@RequestBody Map<String, String> request) {
        return userRepository.save(new User(request.get("nickname"), request.get("profileImgUrl")));
    }

    @GetMapping
    public User getUser(@RequestHeader("userId") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

}
