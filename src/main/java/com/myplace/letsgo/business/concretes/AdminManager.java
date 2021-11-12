package com.myplace.letsgo.business.concretes;

import java.util.Optional;

import com.myplace.letsgo.business.abstracts.AdminService;
import com.myplace.letsgo.dataaccess.AdminDao;
import com.myplace.letsgo.models.Admin;

import org.springframework.stereotype.Service;

@Service
public class AdminManager implements AdminService{
    
    private Admin admin;
    private AdminDao adminDao;

    public AdminManager(Admin admin,AdminDao adminDao) {
        this.adminDao = adminDao;
        this.admin=admin;

    }

    @Override
    public Admin saveOneAdmin(Admin admin) {
        
        return adminDao.save(admin);
    }

    @Override
    public Admin updateOneAdmin(Long id, Admin newAdmin) {
        Optional<Admin> admin = adminDao.findById(id);

        if(admin.isPresent()){
            Admin foundedAdmin = admin.get();
            foundedAdmin.setUserName(newAdmin.getUserName());
            foundedAdmin.setPassword(newAdmin.getPassword());
            

            adminDao.save(foundedAdmin);

            return foundedAdmin;
        }

        return null;
    }

    @Override
    public void deleteOneAdmin(Long id) {
         adminDao.delete(admin);
        
    }

}
