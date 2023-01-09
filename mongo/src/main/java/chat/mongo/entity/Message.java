package chat.mongo.entity;

import chat.mongo.enumerate.MessageType;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "message")
public class Message {

    // private Long userId;

    private String nickname; // 추후 회원 구현되면 -> userId에서 사용자 정보 가져오도록
    private String profileImgUrl;
    private MessageType messageType;
    private String content;
    private LocalDateTime createdAt;
    private Boolean hasAuth;

    // 스레드 - replies

}
