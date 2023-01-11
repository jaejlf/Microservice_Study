package chat.mongo.repository;

import chat.mongo.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findAllByChannelId(Long channelId);

    @Query("{id:'?0'}")
    Optional<Message> findOneById(String id);

    void deleteById(String id);
}
