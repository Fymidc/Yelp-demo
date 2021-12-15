package com.myplace.letsgo.business.concretes;

import java.util.Optional;

import com.myplace.letsgo.business.abstracts.CustomerService;
import com.myplace.letsgo.dataaccess.CustomerDao;
import com.myplace.letsgo.exception.CustomerNotFoundException;
import com.myplace.letsgo.models.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService{

    private final CustomerDao customerDao;

    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;

    }

    @Override
    public Customer saveOneCustomer(Customer customer) {
        
        return customerDao.save(customer);
    }

    @Override
    public Customer updateOneCustomer(Long id, Customer newCustomer) {
        Optional<Customer> customer = customerDao.findById(id);

        if(customer.isPresent()){
            Customer foundedCustomer = customer.get();
            foundedCustomer.setUserName(newCustomer.getUserName());
            foundedCustomer.setPassword(newCustomer.getPassword());
            foundedCustomer.setEmail(newCustomer.getEmail());

            customerDao.save(foundedCustomer);

            return foundedCustomer;
        }

        return null;
    }

    @Override
    public void deleteOneCustomer(Long id) {
         customerDao.deleteById(id);
        
    }

    @Override
    public Customer getOneCustomerById(Long id) {
        
        return customerDao.findById(id).orElseThrow(
            ()-> new CustomerNotFoundException("customerid cannot found"+id)
        );
    }

    @Override
    public Customer getOneCustomerByUserName(String userName) {
       
        return customerDao.findByUserName(userName);
    }
    
}
