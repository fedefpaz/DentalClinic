package ProyectoFinal.DentalClinic.Model.DTO;

import lombok.Data;

@Data
public class DentistDTO {
    private Long id;
    private String surname;
    private String name;
    private String license;

    public DentistDTO(String surname, String name, String license) {
        this.surname = surname;
        this.name = name;
        this.license = license;
    }
}
