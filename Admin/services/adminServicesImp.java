package com.maaz.project.Admin.services;

import com.maaz.project.Admin.data.adminData;
import com.maaz.project.Admin.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class adminServicesImp implements adminServices
{

    @Autowired
    private adminRepository adminrepository;

    //Get All Admins
    @Override
    public List<adminData> getAllAdmins()
    {
        return adminrepository.findAll();
    }

    //Get Single Admin by ID
    @Override
    public Optional<adminData> getAdmin(long AdminId)
    {
        return adminrepository.findById(AdminId);
    }

    //Create a Admin
    @Override
    public adminData createAdmin(adminData admin)
    {
       adminrepository.save(admin);
        return admin;
    }

    //Delete Admin Data by ID
    @Override
    public adminData deleteAdmin(long AdminId)
    {
        adminrepository.deleteById(AdminId);
        return null;
    }

    //Update Admin Data by ID
    @Override
    public adminData updateAdmin(long id, adminData admin, adminData updtAdmin)
    {
        updtAdmin.setName(admin.getName());
        updtAdmin.setEmail(admin.getEmail());
        updtAdmin.setAddress(admin.getAddress());
        adminrepository.save(updtAdmin);
        return updtAdmin;
    }

}
