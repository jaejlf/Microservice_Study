package msa.userservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import msa.userservice.entity.User;

import java.util.List;

@Getter
@Builder
public class UserResponse {

    private Long userId;
    private String email;
    private String name;

    // 주문정보
    private List<OrderResponse> orders;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
