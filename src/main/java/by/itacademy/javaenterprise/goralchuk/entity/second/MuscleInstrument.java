package by.itacademy.javaenterprise.goralchuk.entity.second;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@ToString(callSuper=true)
@Entity
@DiscriminatorValue("MI")
public class MuscleInstrument extends BuildingInstrument {
    private double mass;
}
