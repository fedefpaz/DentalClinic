package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Model.DTO.AddressDTO;
import ProyectoFinal.DentalClinic.Model.DTO.PatientDTO;
import ProyectoFinal.DentalClinic.Service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    IPatientService patientService;

    @Test
    void findById() throws Exception{
        PatientDTO patient1 = patientService.findById(1L);

        assertNotNull(patient1);
    }

    @Test
    void create() throws Exception{
        AddressDTO address = new AddressDTO("Calle Falsa", "123", "Colonia", "Ciudad");
        AddressDTO address2 = new AddressDTO("Siempreviva", "742", "Springfield", "Oregon");
        AddressDTO address3 = new AddressDTO("Piermont Dr.", "3828", "Albuquerque", "Nuevo Mexico");

        PatientDTO patient1 = new PatientDTO("Pepe","Perez","12345678", LocalDate.now(), address);
        PatientDTO patient2 = new PatientDTO("Juan","Gomez","87654321", LocalDate.of(2021,3,13), address2);
        PatientDTO patient3 = new PatientDTO("Walter","White","12345678", LocalDate.now(), address3);

        patientService.create(patient1);
        patientService.create(patient2);
        patientService.create(patient3);

        assertTrue(patientService.findAll().size() > 0);
    }

    @Test
    void deleteById() throws Exception {
        patientService.deleteById(1L);

        PatientDTO patient1 = patientService.findById(1L);

        assertNull(patient1);
    }

    @Test
    void update() throws Exception {
        PatientDTO patient2 = patientService.findById(2L);
        patient2.setName("Diego");
        patient2.setSurname("Valoyes");
        patient2.setDni("09876543");
        patient2.getAddressId().setStreet("Calle 2");
        patient2.getAddressId().setNumber("456");
        patient2.getAddressId().setCity("Colonia 2");
        patient2.getAddressId().setProvince("BsAs");

        patientService.update(patient2);

        assertEquals("Diego", patient2.getName());
    }

    @Test
    void findAll() throws Exception {

        assertNotNull(patientService.findAll());
    }
}