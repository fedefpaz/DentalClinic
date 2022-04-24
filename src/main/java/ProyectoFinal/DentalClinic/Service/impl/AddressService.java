package ProyectoFinal.DentalClinic.Service.impl;

import ProyectoFinal.DentalClinic.Model.Address;
import ProyectoFinal.DentalClinic.Model.DTO.AddressDTO;
import ProyectoFinal.DentalClinic.Repository.IAddressRepository;
import ProyectoFinal.DentalClinic.Service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    ObjectMapper objectmapper;

    @Override
    public AddressDTO findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        AddressDTO newAddress = null;
        if(address.isPresent())
            newAddress = objectmapper.convertValue(address, AddressDTO.class);
        return newAddress;
    }

    @Override
    public AddressDTO create(AddressDTO address) {
        Address newAddress = objectmapper.convertValue(address, Address.class);
        addressRepository.save(newAddress);
        return address;
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO update(AddressDTO address) {
        Address newAddress = objectmapper.convertValue(address, Address.class);
        addressRepository.save(newAddress);
        return address;
    }

    @Override
    public Set<AddressDTO> findAll() {
        List<Address> newAddress = addressRepository.findAll();
        Set<AddressDTO> addressDTOS = new HashSet<>();
        for (Address address : newAddress) {
            addressDTOS.add(objectmapper.convertValue(address, AddressDTO.class));
        }
        return addressDTOS;
    }
}
