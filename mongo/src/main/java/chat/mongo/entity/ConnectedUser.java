package chat.mongo.entity;

import java.time.LocalDateTime;

public class ConnectedUser {

    private Long userId;
    private LocalDateTime latestConnection;

    public ConnectedUser(Long userId, LocalDateTime latestConnection) {
        this.userId = userId;
        this.latestConnection = latestConnection;
    }

}
