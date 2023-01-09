package chat.mongo.dto.response;

import chat.mongo.entity.Message;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Builder
public class MessageResponse {

    private Long userId;
    private String nickname;
    private String profileImgUrl;
    private String messageType;
    private String content;
    private LocalDateTime createdAt;
    private Boolean hasAuthorized;

    public static MessageResponse of(DummyUserResponse user, Message message) {
        return MessageResponse.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImgUrl(user.getProfileImgUrl())
                .messageType(message.getMessageType())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .hasAuthorized(Objects.equals(user.getUserId(), message.getUserId()))
                .build();
    }

}

