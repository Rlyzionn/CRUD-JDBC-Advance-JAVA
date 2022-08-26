package com.maaz.project.Admin.services;

import com.maaz.project.Admin.data.adminData;
import java.util.List;
import java.util.Optional;

public interface adminServices
{
    public List<adminData> getAllAdmins();

    public Optional<adminData> getAdmin(long AdminId);

    public adminData createAdmin(adminData admin);

    public adminData  deleteAdmin(long x);

    public adminData updateAdmin(long AdminId, adminData admin, adminData updAdmin);
}

