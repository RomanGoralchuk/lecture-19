package by.itacademy.javaenterprise.goralchuk.entity.third;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class SurgicalInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String collection;
    private String toolDesign;
    private String functionalPurpose;
}
