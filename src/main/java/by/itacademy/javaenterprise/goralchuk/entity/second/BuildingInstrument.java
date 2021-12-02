package by.itacademy.javaenterprise.goralchuk.entity.second;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "INSTR_TYPE")
public abstract class BuildingInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classification;
    private String name;
}
