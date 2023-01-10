package msa.outuser.dummy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class DummyController {

    private final DummyRepository dummyRepository;

    @PostMapping("/new/{userId}")
    public Dummy createDummy(@PathVariable Long userId) {
        return dummyRepository.save(new Dummy(userId));
    }

    @PutMapping("/on/{userId}")
    public Dummy dummyOn(@PathVariable Long userId) {
        Dummy dummy = dummyRepository.findByUserId(userId);
        dummy.update(!dummy.isOn());
        return dummyRepository.save(dummy);
    }

}
