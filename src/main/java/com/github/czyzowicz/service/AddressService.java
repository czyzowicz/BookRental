package com.github.czyzowicz.service;

import com.github.czyzowicz.model.Address;

import java.util.Set;

public interface AddressService {

    Set <Address> findAllByCityAndState (String city, String state);
    void create (Address adress);
    Set<Address> findAll ();
}
