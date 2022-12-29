package chat.demo.controller;

import chat.demo.dto.MessageRequest;
import chat.demo.dto.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MessageResponse greeting(MessageRequest msg) throws Exception {
        Thread.sleep(100); // delay

        log.info("작성자 : " + msg.getName());
        log.info("내용 : " + msg.getContent());
        log.info("시간 : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));

        return new MessageResponse(
                msg.getName(),
                msg.getContent(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));
    }

}
