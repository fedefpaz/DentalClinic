package ProyectoFinal.DentalClinic.Controller;

import ProyectoFinal.DentalClinic.Model.DTO.AppointmentDTO;
import ProyectoFinal.DentalClinic.Service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> saveAppointments(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Set<AppointmentDTO>> findAppointment() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointment) {
        appointmentService.update(appointment);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppointmentDTO> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
