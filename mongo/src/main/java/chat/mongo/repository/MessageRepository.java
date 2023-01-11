package chat.mongo.repository;

import chat.mongo.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findAllByChannelId(Long channelId);
}
