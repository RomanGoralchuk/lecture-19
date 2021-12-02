package by.itacademy.javaenterprise.goralchuk.entity.third;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@ToString(callSuper=true)
@Entity
public class ElevatorInstrument extends SurgicalInstrument {
    private String typeOfConstruction;
}
