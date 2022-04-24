package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Model.DTO.DentistDTO;
import ProyectoFinal.DentalClinic.Model.Dentist;
import ProyectoFinal.DentalClinic.Repository.IDentistRepository;
import ProyectoFinal.DentalClinic.Service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper objectmapper;

    @Override
    public DentistDTO findById(Long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO newDentist = null;
        if(dentist.isPresent())
            newDentist = objectmapper.convertValue(dentist, DentistDTO.class);
        return newDentist;
    }

    @Override
    public DentistDTO create(DentistDTO dentist) {
        Dentist newDentist = objectmapper.convertValue(dentist, Dentist.class);
        dentistRepository.save(newDentist);
        return dentist;
    }

    @Override
    public void deleteById(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public DentistDTO update(DentistDTO dentist) {
        Dentist newDentist = objectmapper.convertValue(dentist, Dentist.class);
        dentistRepository.save(newDentist);
        return dentist;
    }

    @Override
    public Set<DentistDTO> findAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTOS = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDTOS.add(objectmapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTOS;
    }
}
