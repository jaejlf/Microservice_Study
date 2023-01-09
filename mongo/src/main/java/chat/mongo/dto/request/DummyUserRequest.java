package chat.mongo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DummyUserRequest {
    private Long userId;
    private String nickname;
    private String profileImgUrl;
}
