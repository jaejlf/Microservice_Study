package chat.mongo.controller;

import chat.mongo.dto.request.MessageRequest;
import chat.mongo.dto.response.MessageResponse;
import chat.mongo.dto.response.ResultResponse;
import chat.mongo.entity.Message;
import chat.mongo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/send/{roomId}")
    public void sendMessaage(@RequestHeader("userId") Long userId,
                             @DestinationVariable Long roomId,
                             @Payload MessageRequest request) {
        chatService.sendMessaage(userId, roomId, request);
    }

    @PostMapping("/send/{roomId}")
    public void postMessage(@RequestHeader("userId") Long userId,
                            @PathVariable Long roomId,
                            @RequestBody MessageRequest request) {
        chatService.sendMessaage(userId, roomId, request);
    }

    @GetMapping("/list/{roomId}")
    public ResponseEntity<Object> getMessages(@RequestHeader("userId") Long userId, @PathVariable String roomId) {
        List<MessageResponse> result = chatService.getMessages(userId, Long.parseLong(roomId));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResultResponse.ok("메시지 리스트 조회", result));
    }

}
