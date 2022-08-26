package com.maaz.project.Admin.data;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class adminData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AdminId;
    private String name;
    private String email;
    private String address;
    private String password;

    //Getters and Setters
    public Long getId() {
        return AdminId;
    }

    public void setId(Long id) {
        this.AdminId = AdminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
            this.password = password;
    }



    public adminData(Long AdminId, String name, String email, String address)
    {
        this.AdminId = AdminId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public adminData()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "User{" + "AdminId=" + AdminId + ", name='" + name + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", password= '" + password + "}'";
    }
}