package chat.mongo.controller;

import chat.mongo.dto.request.MessageRequest;
import chat.mongo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/send/{roomId}")
    public void sendMessage(@RequestHeader("userId") Long userId,
                            @DestinationVariable Long roomId,
                            @Payload MessageRequest request) {
        chatService.sendMessage(userId, roomId, request);
    }

    @PostMapping("/send/{roomId}")
    public void postMessage(@RequestHeader("userId") Long userId,
                            @PathVariable Long roomId,
                            @RequestBody MessageRequest request) {
        log.info(request.getMessageType());
        log.info(request.getContent());
        chatService.sendMessage(userId, roomId, request);
    }

}
