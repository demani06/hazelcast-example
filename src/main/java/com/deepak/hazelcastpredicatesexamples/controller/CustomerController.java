package com.deepak.hazelcastpredicatesexamples.controller;

import com.deepak.hazelcastpredicatesexamples.domain.Customer;
import com.deepak.hazelcastpredicatesexamples.service.CommonBackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerController {

    @Autowired
    private CommonBackingService commonBackingService;

    @GetMapping("/getCustomers")
    public Collection<Customer> getCustomersWithPredicate(){
        return commonBackingService.getCustomersObjectFromMap();
    }

    @GetMapping("/addCustomers")
    public String addCustsomersToMap(){
        return commonBackingService.addCustomerObjectToMap();
    }
}
