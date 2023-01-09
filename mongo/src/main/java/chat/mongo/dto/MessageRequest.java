package chat.mongo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {

    private String name;
    private String content;

    public MessageRequest(String name, String content) {
        this.name = name;
        this.content = content;
    }

}
