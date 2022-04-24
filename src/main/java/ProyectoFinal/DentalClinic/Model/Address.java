package ProyectoFinal.DentalClinic.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String city;
    private String province;
}