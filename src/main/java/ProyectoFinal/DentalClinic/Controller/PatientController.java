package ProyectoFinal.DentalClinic.Controller;

import ProyectoFinal.DentalClinic.Model.DTO.PatientDTO;
import ProyectoFinal.DentalClinic.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patient){
        patientService.create(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public PatientDTO getPatient(@PathVariable Long id){
        return patientService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patient){
        patientService.update(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public Collection<PatientDTO> getFindAllPatient(){
        return patientService.findAll();
    }
}
