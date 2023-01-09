package chat.mongo.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "message")
public class Message {

    private Long userId;
    private Long roomId;
    private String messageType;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

    // 스레드 - replies

    public Message(Long userId, Long roomId, String messageType, String content) {
        this.userId = userId;
        this.roomId = roomId;
        this.messageType = messageType;
        this.content = content;
    }

}
