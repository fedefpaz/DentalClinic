package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Model.Appointment;
import ProyectoFinal.DentalClinic.Model.DTO.AppointmentDTO;
import ProyectoFinal.DentalClinic.Repository.IAppointmentRepository;
import ProyectoFinal.DentalClinic.Service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;
    @Autowired
    ObjectMapper objectmapper;

    @Override
    public AppointmentDTO findById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO newAppointment = null;
        if(appointment.isPresent())
            newAppointment = objectmapper.convertValue(appointment, AppointmentDTO.class);
        return newAppointment;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointment) {
        Appointment newAppointment = objectmapper.convertValue(appointment, Appointment.class);
        appointmentRepository.save(newAppointment);
        return appointment;
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointment) {
        Appointment newAppointment = objectmapper.convertValue(appointment, Appointment.class);
        appointmentRepository.save(newAppointment);
        return appointment;
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(objectmapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }
}
