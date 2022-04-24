package ProyectoFinal.DentalClinic.Model.DTO;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;


@Data
public class AppointmentDTO {
    private Long id;
    private Time time;
    private LocalDate date;
    private PatientDTO patient;
    private DentistDTO dentist;

}
