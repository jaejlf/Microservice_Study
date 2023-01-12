package chat.mongo.service;

import chat.mongo.constant.KafkaConstants;
import chat.mongo.dto.request.MessageRequest;
import chat.mongo.dto.response.MessageResponse;
import chat.mongo.entity.Message;
import chat.mongo.repository.MessageRepository;
import chat.mongo.web.UserClient;
import chat.mongo.web.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;
    private final UserClient userClient;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(Long userId, Long channelId, MessageRequest request) throws ExecutionException, InterruptedException {
        UserResponse writer = userClient.getUser(userId);

        Message message;
        if (request.getId() == null) {
            message = new Message(
                    writer.getId(),
                    channelId,
                    request.getType(),
                    request.getContent()
            );
        } else {
            message = messageRepository.findOneById(request.getId()).get(); // Optional 예외처리 전
            message.updateMessage(request.getType(), request.getContent());
        }

        messageRepository.save(message);
        simpMessagingTemplate.convertAndSend("/sub/" + channelId, message);

        // IMAGE, FILE 타입 업로드 구현 전
        // delete 스레드 있/없
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, userId).get();

    }

    public List<MessageResponse> getMessages(Long userId, Long channelId) {
        List<Message> messages = messageRepository.findAllByChannelId(channelId);
        return messages
                .stream()
                .map(x -> MessageResponse.of(x, userClient.getUser(x.getUserId()), userId))
                .collect(Collectors.toList());
    }

}