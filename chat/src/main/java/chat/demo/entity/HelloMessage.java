package chat.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HelloMessage {

    private String name;

    public HelloMessage(String name) {
        this.name = name;
    }

}
