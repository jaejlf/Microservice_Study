package chat.mongo.entity;

import chat.mongo.enumerate.MessageType;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "message")
public class Message {

    @Id
    private String id;
    private Long channelId;
    private Long userId;
    private MessageType type;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Message> replies = new ArrayList<>();

    public Message(Long channelId, Long userId, MessageType type, String content) {
        this.channelId = channelId;
        this.userId = userId;
        this.type = type;
        this.content = content;
    }

    public void updateMessage(MessageType type, String content) {
        this.type = type;
        this.content = content;
    }

}
