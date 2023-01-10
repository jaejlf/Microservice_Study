package msa.outuser.dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dummyId;
    private Long userId;
    private boolean isOn = false;

    public Dummy(Long userId) {
        this.userId = userId;
    }

    public void update(boolean isOn) {
        this.isOn = isOn;
    }

}
