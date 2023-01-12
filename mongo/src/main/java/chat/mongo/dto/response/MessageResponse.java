package chat.mongo.dto.response;

import chat.mongo.entity.Message;
import chat.mongo.enumerate.MessageType;
import chat.mongo.web.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class MessageResponse {

    private String id;
    private MessageType type;
    private String content;
    private LocalDateTime createdAt;
    private UserResponse writer;
    private List<Message> replies;
    private Boolean hasAuthorized;

    public static MessageResponse of(Message message, UserResponse writer, Long userId) {
        return MessageResponse.builder()
                .id(message.getId())
                .type(message.getType())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .writer(writer)
                .replies(message.getReplies())
                .hasAuthorized(Objects.equals(writer.getId(), userId))
                .build();
    }

}

