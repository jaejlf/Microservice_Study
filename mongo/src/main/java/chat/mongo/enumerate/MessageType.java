package chat.mongo.enumerate;

import lombok.Getter;

@Getter
public enum MessageType {
    WELCOME, TEXT, IMAGE, FILE, MODIFIED
}