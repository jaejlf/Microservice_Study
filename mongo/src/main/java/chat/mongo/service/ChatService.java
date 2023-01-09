package chat.mongo.service;

import chat.mongo.dto.request.MessageRequest;
import chat.mongo.dto.response.DummyUserResponse;
import chat.mongo.dto.response.MessageResponse;
import chat.mongo.entity.Message;
import chat.mongo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final DummyUserService dummyUserService;
    private final MessageRepository messageRepository;

    public void sendMessage(Long userId, Long roomId, MessageRequest request) {
        DummyUserResponse user = dummyUserService.getUser(userId);
        Message message = new Message(
                userId,
                roomId,
                request.getMessageType(),
                request.getContent()
        );
        messageRepository.save(message);
        simpMessagingTemplate.convertAndSend("/topic/" + roomId, MessageResponse.of(user, message));
    }

}
