package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Exception.ResourceNotFoundException;
import ProyectoFinal.DentalClinic.Model.DTO.PatientDTO;
import ProyectoFinal.DentalClinic.Model.Patient;
import ProyectoFinal.DentalClinic.Repository.IPatientRepository;
import ProyectoFinal.DentalClinic.Service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper objectmapper;

    @Override
    public PatientDTO findById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO newPatient = null;

        if(patient.isPresent()) {
            newPatient = objectmapper.convertValue(patient, PatientDTO.class);
        }
        return newPatient;
    }

    @Override
    public PatientDTO create(PatientDTO patient) {
        Patient newPatient = objectmapper.convertValue(patient, Patient.class);
        patientRepository.save(newPatient);
        return patient;
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDTO update(PatientDTO patient) {
        Patient newPatient = objectmapper.convertValue(patient, Patient.class);
        patientRepository.save(newPatient);
        return patient;
    }

    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<PatientDTO>();

        for(Patient patient : patients) {
            patientsDTO.add(objectmapper.convertValue(patient, PatientDTO.class));
        }
        return patientsDTO;
    }
}
