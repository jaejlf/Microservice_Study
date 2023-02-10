package study.asyncone;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/messages")
    public void printMessage() {
        for (int i = 1; i <= 100; i++) {
            messageService.print(i + "");
        }
    }

}
