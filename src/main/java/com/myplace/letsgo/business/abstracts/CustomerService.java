package com.myplace.letsgo.business.abstracts;

import com.myplace.letsgo.models.Customer;

public interface CustomerService {
   Customer saveOneCustomer(Customer customer);
   Customer updateOneCustomer(Long id,Customer newCustomer);
   Customer getOneCustomerById(Long id);
   void deleteOneCustomer(Long id);
}
