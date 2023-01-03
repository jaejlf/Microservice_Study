package chat.demo.controller;

import chat.demo.constant.KafkaConstants;
import chat.demo.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class ChatController {

    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;

    @PostMapping(value = "/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody MessageDto message) throws ExecutionException, InterruptedException {
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        log.info("토픽에 메시지 전송 완료");
    }

    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void broadcastGroupMessage(@Payload MessageDto message) throws ExecutionException, InterruptedException {
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        log.info("토픽에 메시지 전송 완료");
//        return new MessageDto(
//                message.getName(),
//                message.getContent(),
//                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));
    }

}
