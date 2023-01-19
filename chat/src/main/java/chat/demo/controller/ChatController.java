package chat.demo.controller;

import chat.demo.dto.MessageRequest;
import chat.demo.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(MessageRequest msg) throws Exception {
        Thread.sleep(100); // delay

        log.info("작성자 : " + msg.getName());
        log.info("내용 : " + msg.getContent());
        log.info("시간 : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));

        MessageResponse response = new MessageResponse(
                msg.getName(),
                msg.getContent(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")));

        simpMessagingTemplate.convertAndSend("/sub/1", response);
    }

}