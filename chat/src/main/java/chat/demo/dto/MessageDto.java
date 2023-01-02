package chat.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {

    private String name;
    private String content;
    private String timestamp;

    public MessageDto(String name, String content, String timestamp) {
        this.name = name;
        this.content = content;
        this.timestamp = timestamp;
    }

}
