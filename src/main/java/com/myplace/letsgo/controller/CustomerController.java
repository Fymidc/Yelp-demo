package com.myplace.letsgo.controller;

import com.myplace.letsgo.business.abstracts.CustomerService;
import com.myplace.letsgo.models.Customer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private final CustomerService customerService;
    

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer add(@RequestBody Customer customer){
        return customerService.saveOneCustomer(customer);
    }

    @PutMapping("{id}")
    public Customer updadateOneCustomer(@PathVariable Long id , @RequestBody Customer newCustomer){
        return customerService.updateOneCustomer(id, newCustomer);
    }

    @GetMapping("{id}")
    public Customer getOneCustomer(@PathVariable Long id){
        return customerService.getOneCustomerById(id);
    }

    @DeleteMapping("{id}")
    public void deleteOneCustomer(@PathVariable Long id ){
        customerService.deleteOneCustomer(id);
    }

}

//customer oluştutuldu id-1