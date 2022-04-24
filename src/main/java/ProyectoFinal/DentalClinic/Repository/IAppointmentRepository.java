package ProyectoFinal.DentalClinic.Repository;

import ProyectoFinal.DentalClinic.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}