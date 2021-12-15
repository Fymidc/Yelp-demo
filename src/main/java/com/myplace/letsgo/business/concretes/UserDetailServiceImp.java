package com.myplace.letsgo.business.concretes;

import com.myplace.letsgo.dataaccess.CustomerDao;
import com.myplace.letsgo.models.Customer;
import com.myplace.letsgo.security.JwtUserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    private CustomerDao customerDao;

    
    public UserDetailServiceImp(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.findByUserName(username);
        return JwtUserDetails.create(customer); //jwt create kullnarak verdiğimiz user ile jwt user oluşturur.
    }
    
    public UserDetails loadUserById(Long id){
        Customer customer = customerDao.findById(id).get();
        return JwtUserDetails.create(customer);
    }

}
