package com.digi.banksystem.service.impl;

import com.digi.banksystem.exception.NotFoundException;
import com.digi.banksystem.model.Address;
import com.digi.banksystem.model.User;
import com.digi.banksystem.model.requestdto.AddressDTO;
import com.digi.banksystem.model.responsedto.AddressResponseDTO;
import com.digi.banksystem.repository.AddressRepository;
import com.digi.banksystem.repository.UserRepository;
import com.digi.banksystem.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(AddressDTO addressDTO, String email) {
        User user = userRepository.getByEmail(email);
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHouse(addressDTO.getHouse());
        address.setUser(user);
        addressRepository.save(address);
    }

    @Override
    public AddressResponseDTO getAddressById(int id) throws NotFoundException {
        Optional<Address> addresses = addressRepository.findById(id);
        if (addresses.isEmpty()) {
            throw new NotFoundException("address not found with given ID");
        }
        Address address = addresses.get();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(address, AddressResponseDTO.class);
    }
}
