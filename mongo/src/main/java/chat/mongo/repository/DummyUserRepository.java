package chat.mongo.repository;

import chat.mongo.entity.DummyUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface DummyUserRepository extends MongoRepository<DummyUser, String> {
    DummyUser findByUserId(Long userId);
}

