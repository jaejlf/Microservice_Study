package chat.mongo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageRequest {
    private String messageType;
    private String content;
}
