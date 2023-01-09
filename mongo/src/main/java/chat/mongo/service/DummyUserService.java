package chat.mongo.service;

import chat.mongo.dto.request.DummyUserRequest;
import chat.mongo.dto.response.DummyUserResponse;
import chat.mongo.entity.DummyUser;
import chat.mongo.repository.DummyUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DummyUserService {

    private final DummyUserRepository dummyUserRepository;

    public DummyUserResponse signUp(DummyUserRequest request) {
        DummyUser dummyUser = new DummyUser(
                request.getUserId(),
                request.getNickname(),
                request.getProfileImgUrl()
        );
        return DummyUserResponse.of(dummyUserRepository.save(dummyUser));
    }

    public DummyUserResponse getUser(Long userId) {
        return DummyUserResponse.of(dummyUserRepository.findByUserId(userId));
    }

}
