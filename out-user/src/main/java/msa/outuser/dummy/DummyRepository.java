package msa.outuser.dummy;

import msa.outuser.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
    Dummy findByUserId(Long userId);
}
