package chat.demo.repository;

import chat.demo.entity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByName(String name);
}
