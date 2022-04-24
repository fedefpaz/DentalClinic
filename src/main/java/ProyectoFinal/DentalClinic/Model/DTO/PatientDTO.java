package ProyectoFinal.DentalClinic.Model.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private String surname;
    private String dni;
    private LocalDate dischargeDate;
    private AddressDTO addressId;

    public PatientDTO(String name, String surname, String dni, LocalDate dischargeDate, AddressDTO addressId) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
        this.addressId = addressId;
    }
}
