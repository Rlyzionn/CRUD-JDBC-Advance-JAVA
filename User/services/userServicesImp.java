package com.maaz.project.User.services;

import com.maaz.project.User.data.userData;
import com.maaz.project.User.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServicesImp implements userServices
{
    @Autowired
    private userRepository userrepository;

    //Get All Students
    @Override
    public List<userData> getAllUsers()
    {
        return userrepository.findAll();
    }

    //Get Single Student by ID
    @Override
    public Optional<userData> getUser(long UserId)
    {
        return userrepository.findById(UserId);
    }

    //Create a User
    @Override
    public userData createUser(userData user) {

        userrepository.save(user);
        return user;
    }

    //Delete User Data by ID
    @Override
    public userData deleteUser(long UserId)
    {
        userrepository.deleteById(UserId);
        return null;
    }

    //Update User Data by ID
    @Override
    public userData updateUser(long id, userData user, userData updtUser)
    {
        updtUser.setName(user.getName());
        updtUser.setEmail(user.getEmail());
        updtUser.setAddress(user.getAddress());
        userrepository.save(updtUser);
        return updtUser;

    }



}
