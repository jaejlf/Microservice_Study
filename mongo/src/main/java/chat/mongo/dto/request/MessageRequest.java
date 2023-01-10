package chat.mongo.dto.request;

import chat.mongo.enumerate.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private String content;
}
