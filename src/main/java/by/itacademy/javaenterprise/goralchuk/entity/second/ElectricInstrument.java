package by.itacademy.javaenterprise.goralchuk.entity.second;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@ToString(callSuper=true)
@Entity
@DiscriminatorValue("EI")
public class ElectricInstrument extends BuildingInstrument {
    private int power;
}
