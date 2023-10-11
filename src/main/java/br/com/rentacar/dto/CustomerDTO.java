package br.com.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO extends RepresentationModel {
    private int id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;
    private String lastName;
    private String city;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
