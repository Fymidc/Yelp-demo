package com.myplace.letsgo.controller;

import com.myplace.letsgo.business.abstracts.AdminService;
import com.myplace.letsgo.models.Admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/{id}")
    public Admin getOneAdminById(@PathVariable Long id){
        return adminService.getOneAdminById(id);
    }

    @PostMapping
    public Admin saveOneAdmin(@RequestBody Admin admin){
       return adminService.saveOneAdmin(admin);
    }

    @PutMapping("/{id}")
    public Admin updateOnAdmin(@PathVariable Long id, @RequestBody Admin newAdmin){
        return adminService.updateOneAdmin(id, newAdmin);
    }

    @DeleteMapping("/{id}")
    public void deleteOneAdmin(@PathVariable Long id){
        adminService.deleteOneAdmin(id);
    }
    



}

//1 admin oluşturuldu id-1
