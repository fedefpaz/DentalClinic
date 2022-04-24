package ProyectoFinal.DentalClinic.Controller;

import ProyectoFinal.DentalClinic.Model.DTO.DentistDTO;
import ProyectoFinal.DentalClinic.Service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<DentistDTO> saveDentist(@RequestBody DentistDTO dentist){
        dentistService.create(dentist);
        return new ResponseEntity<>(dentist, HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public DentistDTO getDentist(@PathVariable Long id){
        return dentistService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<DentistDTO> updateDentist(@RequestBody DentistDTO dentist){
        dentistService.update(dentist);
        return new ResponseEntity<>(dentist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DentistDTO> deleteDentist(@PathVariable Long id){
        dentistService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public Collection<DentistDTO> getFindAllDentist(){
        return dentistService.findAll();
    }
}
