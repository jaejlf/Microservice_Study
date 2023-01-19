package chat.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class MessageRequest {

    private Long channelId;
    private String name;
    private String content;

}
