package by.itacademy.javaenterprise.goralchuk.entity.first;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper=true)
@Entity
@Table
public class WindInstrument extends MusicalInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;

    public WindInstrument(Long id) {
        this.id = id;
    }
}
