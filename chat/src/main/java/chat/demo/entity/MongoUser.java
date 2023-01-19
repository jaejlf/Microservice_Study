package chat.demo.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
public class MongoUser {
    public String name;
    public int age;

    public MongoUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
