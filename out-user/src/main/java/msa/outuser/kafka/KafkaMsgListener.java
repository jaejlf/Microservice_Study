package msa.outuser.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMsgListener {

    // Kafka로부터 메시지 전달받는
    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Long userId) {
        log.info("메시지 전송 받는 중... userId = " + userId);
    }

}