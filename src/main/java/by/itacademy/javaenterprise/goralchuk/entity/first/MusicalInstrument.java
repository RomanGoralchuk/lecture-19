package by.itacademy.javaenterprise.goralchuk.entity.first;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class MusicalInstrument {
    private String classification;
    private String name;
}
