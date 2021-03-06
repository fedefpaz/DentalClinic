package ProyectoFinal.DentalClinic.Repository;

import ProyectoFinal.DentalClinic.Model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}