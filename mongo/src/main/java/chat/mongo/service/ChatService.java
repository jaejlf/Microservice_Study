package chat.mongo.service;

import chat.mongo.dto.request.MessageRequest;
import chat.mongo.dto.response.MessageResponse;
import chat.mongo.entity.Message;
import chat.mongo.enumerate.MessageType;
import chat.mongo.repository.MessageRepository;
import chat.mongo.web.client.UserClient;
import chat.mongo.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;
    private final UserClient userClient;

    public void sendMessaage(Long userId, Long roomId, MessageRequest request) {
        UserResponse user = userClient.getUser(userId);
        Message message = new Message(
                user.getUserId(),
                roomId,
                MessageType.TEXT,
                request.getContent()
        );
        messageRepository.save(message);
        simpMessagingTemplate.convertAndSend("/topic/" + roomId, MessageResponse.of(user, message));
    }

    public List<MessageResponse> getMessages(Long userId, Long roomId) {
        UserResponse user = userClient.getUser(userId);
        List<Message> messages = messageRepository.findAllByRoomId(roomId);
        return messages.stream().map(x -> MessageResponse.of(user, x)).collect(Collectors.toList());
    }

}
