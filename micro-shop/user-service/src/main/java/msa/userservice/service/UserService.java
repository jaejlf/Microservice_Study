package msa.userservice.service;

import lombok.RequiredArgsConstructor;
import msa.userservice.dto.request.UserRequest;
import msa.userservice.dto.response.UserResponse;
import msa.userservice.entity.User;
import msa.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        User user = new User(
                userRequest.getEmail(),
                userRequest.getName(),
                userRequest.getPassword() // raw로 바로 저장
        );
        userRepository.save(user);
        return UserResponse.of(user);
    }

}
