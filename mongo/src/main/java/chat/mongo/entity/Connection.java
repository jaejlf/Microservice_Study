package chat.mongo.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "connection")
public class Connection {

    private Long channelId;
    private List<ConnectedUser> connectedUsers;

    public Connection(Long channelId, List<ConnectedUser> connectedUsers) {
        this.channelId = channelId;
        this.connectedUsers = connectedUsers;
    }

}
