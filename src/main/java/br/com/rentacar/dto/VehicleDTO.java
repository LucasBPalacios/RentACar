package br.com.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleDTO {
    private int id;
    private String modelName;
    private String assembler;
    private int manufactureYear;
    private int modelYear;
    public String getPrincipalInfo(){
        return this.id + " - " + this.modelName + " | " + this.modelYear;
    }
}
