package chat.mongo.web.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserResponse implements Serializable {
    private Long userId;
    private String nickname;
    private String profileImgUrl;
}
