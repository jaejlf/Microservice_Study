package chat.mongo.entity;

import chat.mongo.enumerate.MessageType;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "message")
public class Message {

    private Long userId;
    private Long roomId;
    private MessageType messageType;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

    // 스레드 - replies

    public Message(Long userId, Long roomId, MessageType messageType, String content) {
        this.userId = userId;
        this.roomId = roomId;
        this.messageType = messageType;
        this.content = content;
    }

}
