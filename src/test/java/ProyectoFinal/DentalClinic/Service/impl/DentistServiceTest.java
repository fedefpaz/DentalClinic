package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Model.DTO.DentistDTO;
import ProyectoFinal.DentalClinic.Service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    public void create() throws Exception {
        DentistDTO dentist1 = new DentistDTO("Herrera","Guido","1234567");
        DentistDTO dentist2 = new DentistDTO("Perez","Rafael","7654321");
        DentistDTO dentist3 = new DentistDTO("Diaz","Enzo","34578915");

        dentistService.create(dentist1);
        dentistService.create(dentist2);
        dentistService.create(dentist3);

        assertTrue(dentistService.findAll().size() > 0);

    }

    @Test
    void findById() throws Exception{

        DentistDTO dentist1 = dentistService.findById(1L);

        assertNotNull(dentist1);
    }

    @Test
    void update() throws Exception {

        DentistDTO dentist2 = dentistService.findById(2L);
        dentist2.setName("Hector");
        dentist2.setSurname("Fertoli");
        dentist2.setLicense("09876543");

        dentistService.update(dentist2);

        assertEquals("Hector", dentist2.getName());
    }

    @Test
    void findAll() throws Exception {

        assertNotNull(dentistService.findAll());
    }

    @Test
    void deleteById() throws Exception {
        dentistService.deleteById(1L);

        DentistDTO dentist1 = dentistService.findById(1L);

        assertNull(dentist1);
    }
}