package com.myplace.letsgo.dataaccess;

import com.myplace.letsgo.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {
    
}
