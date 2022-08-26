package com.maaz.project.User.data;

import javax.persistence.*;

@Entity
@Table(name="users")
public class userData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;
    private String name;
    private String email;
    private String address;


    //Getters and Setters
    public Long getId() {
        return UserId;
    }

    public void setId(Long id) {
        this.UserId= UserId;
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

    public userData(Long UserId, String name, String email, String address)
    {
        this.UserId = UserId;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public userData() {
        super();
    }

    @Override
    public String toString() {
        return "User{" + "UserId=" + UserId + ", name='" + name + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + '}';
    }
}