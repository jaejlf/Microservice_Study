package chat.mongo.repository;

import chat.mongo.entity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByName(String name);
}

