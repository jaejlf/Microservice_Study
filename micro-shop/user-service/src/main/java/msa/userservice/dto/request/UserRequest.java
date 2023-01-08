package msa.userservice.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public class UserRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

}
