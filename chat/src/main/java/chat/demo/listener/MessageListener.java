package chat.demo.listener;

import chat.demo.constant.KafkaConstants;
import chat.demo.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @Autowired
    SimpMessagingTemplate template;

    // Kafka로부터 메시지 전달받는
    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(MessageDto message) {
        log.info("메시지 전송 받는 중...");
        template.convertAndSend("/topic/greetings", message);
    }

}
