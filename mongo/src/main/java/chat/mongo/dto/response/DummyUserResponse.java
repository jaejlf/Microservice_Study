package chat.mongo.dto.response;

import chat.mongo.entity.DummyUser;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DummyUserResponse {

    private Long userId;
    private String nickname;
    private String profileImgUrl;

    public static DummyUserResponse of(DummyUser user) {
        return DummyUserResponse.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImgUrl(user.getProfileImgUrl())
                .build();
    }

}
