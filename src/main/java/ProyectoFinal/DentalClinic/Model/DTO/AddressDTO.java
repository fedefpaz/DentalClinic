package ProyectoFinal.DentalClinic.Model.DTO;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String province;

    public AddressDTO(String street, String number, String city, String province) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.province = province;
    }
}
