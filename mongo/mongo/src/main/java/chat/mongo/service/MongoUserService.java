package chat.mongo.service;

import chat.mongo.entity.MongoUser;
import chat.mongo.repository.MongoUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MongoUserService {

    private final MongoUserRepository mongoUserRepository;

    public String selectUser(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (mongoUserRepository.findByName(name) == null) {
                return "존재하지 않는 유저!";
            } else {
                return objectMapper.writeValueAsString(mongoUserRepository.findByName(name));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }

    public void saveUser(String name, int age) {
        MongoUser mongoUser = new MongoUser(name, age);
        mongoUserRepository.save(mongoUser);
        log.info("몽고 유저 저장 완료!");
    }

}
