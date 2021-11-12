package com.myplace.letsgo.business.concretes;

import java.util.Optional;

import com.myplace.letsgo.business.abstracts.CustomerService;
import com.myplace.letsgo.dataaccess.CustomerDao;
import com.myplace.letsgo.models.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService{

    private Customer customer;
    private CustomerDao customerDao;

    public CustomerManager(Customer customer,CustomerDao customerDao) {
        this.customerDao = customerDao;
        this.customer=customer;

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
         customerDao.delete(customer);
        
    }

    @Override
    public Customer getOneCustomerById(Long id) {
        
        return customerDao.findById(id).get();
    }
    
}
