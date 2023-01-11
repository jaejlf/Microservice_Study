package chat.mongo.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "connection")
public class Connection {

    private Long roomId;
    private List<ConnectedUser> connectedUsers;

    public Connection(Long roomId, List<ConnectedUser> connectedUsers) {
        this.roomId = roomId;
        this.connectedUsers = connectedUsers;
    }

}
