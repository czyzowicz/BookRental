package com.github.czyzowicz.controller;

import com.github.czyzowicz.model.Address;
import com.github.czyzowicz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping ("/api/addresses")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping
    public void create (@RequestParam String street,
                        @RequestParam String city,
                        @RequestParam String state) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);

        addressService.create(address);
    }

    @GetMapping
    public Set<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{city}_{state}")
    public Set <Address> findAllByCityAndState (@PathVariable String city,
                                                @PathVariable String state) {
        return addressService.findAllByCityAndState(city,state);
    }
}
