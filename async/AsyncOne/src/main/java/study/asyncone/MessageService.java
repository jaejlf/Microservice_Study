package study.asyncone;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Async("threadPoolTaskExecutor")
    public void print(String message) {
        System.out.println(message);
    }

}