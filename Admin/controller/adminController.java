package com.maaz.project.Admin.controller;

import com.maaz.project.Admin.data.adminData;
import com.maaz.project.Admin.repository.adminRepository;
import com.maaz.project.Admin.services.adminServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class adminController
{

    @Autowired
    private adminServicesImp AdminServiceImp;
    @Autowired
    private adminRepository AdminRepository;


    //Test the Connection
    @GetMapping("/admin/check")
    public String Test()
    {
        return "Admin Connection Established";
    }

    //Get all Admins
    @GetMapping("/admin")
    public List<adminData> getAllAdmins()
    {
        return AdminServiceImp.getAllAdmins();
    }

    //Get Admin by ID
    @GetMapping("/admin/{AdminId}")
    public Optional<adminData> getAdmin(@PathVariable long AdminId)
    {
        return AdminServiceImp.getAdmin(AdminId);
    }

    //Create Admin
    @PostMapping("/admin")
    public adminData createAdmin(@RequestBody adminData admin)
    {
        AdminServiceImp.createAdmin(admin);
        return admin;
    }

    //Update Admin using ID
    @PutMapping(value = "/admin/{AdminId}")
    public ResponseEntity<adminData> updateAdmin(@RequestBody adminData admin , @PathVariable("AdminId") long AdminId)
    {
        adminData updtAdmin= AdminRepository.findById(AdminId).orElseThrow();
        AdminServiceImp.updateAdmin(AdminId,admin,updtAdmin);
        return new ResponseEntity<adminData>(HttpStatus.CREATED);
    }

    //Delete Admin using ID
    @DeleteMapping("/admin/{AdminId}")
    public ResponseEntity<adminData> deleteById(@PathVariable("AdminId") long AdminId)
    {

        try
        {
            this.AdminServiceImp.deleteAdmin(AdminId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
