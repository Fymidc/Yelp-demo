package com.myplace.letsgo.dataaccess;

import com.myplace.letsgo.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Long> {
    
}
