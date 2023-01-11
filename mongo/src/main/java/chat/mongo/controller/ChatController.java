package chat.mongo.controller;

import chat.mongo.dto.request.MessageRequest;
import chat.mongo.dto.response.MessageResponse;
import chat.mongo.dto.response.ResultResponse;
import chat.mongo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/pub/{channelId}")
    public void sendMessaage(@RequestHeader("userId") Long userId,
                             @PathVariable Long channelId,
                             @Payload MessageRequest request) {
        chatService.sendMessage(userId, channelId, request);
    }

    @PostMapping("/pub/{channelId}")
    public void postMessage(@RequestHeader("userId") Long userId,
                            @PathVariable Long channelId,
                            @RequestBody MessageRequest request) {
        chatService.sendMessage(userId, channelId, request);
    }

    @GetMapping("/list/{channelId}")
    public ResponseEntity<Object> getMessages(@RequestHeader("userId") Long userId,
                                              @PathVariable String channelId) {
        List<MessageResponse> result = chatService.getMessages(userId, Long.parseLong(channelId));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResultResponse.ok("메시지 리스트 조회", result));
    }

}
