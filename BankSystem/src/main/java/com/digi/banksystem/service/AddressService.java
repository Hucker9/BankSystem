package com.digi.banksystem.service;

import com.digi.banksystem.exception.NotFoundException;
import com.digi.banksystem.model.requestdto.AddressDTO;
import com.digi.banksystem.model.responsedto.AddressResponseDTO;

public interface AddressService{
    void create(AddressDTO addressDTO, String email);

    AddressResponseDTO getAddressById(int id) throws NotFoundException;
}
