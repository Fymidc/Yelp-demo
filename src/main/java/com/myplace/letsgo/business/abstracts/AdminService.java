package com.myplace.letsgo.business.abstracts;

import com.myplace.letsgo.models.Admin;

public interface AdminService {
    Admin getOneAdminById(Long id);
    Admin saveOneAdmin(Admin admin);
   Admin updateOneAdmin(Long id,Admin newAdmin);
   void deleteOneAdmin(Long id);
}
