package chat.mongo.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {

    WELCOME(0, "WELCOME"),
    TEXT(1, "TEXT"),
    IMAGE(2, "IMAGE"),
    FILE(3, "FILE"),
    MODIFIED(4, "MODIFIED");

    private final int code;
    private final String type;

}
