package by.itacademy.javaenterprise.goralchuk.entity.first;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper=true)
@Entity
@Table
public class StringedInstrument extends MusicalInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private int numberOfStrings;

    public StringedInstrument(Long id) {
        this.id = id;
    }
}
