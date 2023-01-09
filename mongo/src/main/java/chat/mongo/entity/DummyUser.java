package chat.mongo.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
public class DummyUser {

    private Long userId;
    private String nickname;
    private String profileImgUrl;

    public DummyUser(Long userId, String nickname, String profileImgUrl) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileImgUrl = profileImgUrl;
    }

}
