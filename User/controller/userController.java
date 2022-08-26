package com.maaz.project.User.controller;

import com.maaz.project.User.data.userData;
import com.maaz.project.User.repository.userRepository;
import com.maaz.project.User.services.userServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class userController
{

        @Autowired
        private userServicesImp UserServiceImp;
        @Autowired
        private userRepository UserRepository;


        //Test the Connection
        @GetMapping("/user/check")
        public String Test()
        {
            return "User Connection Established";
        }

        //Get all Users
        @GetMapping("/user")
        public List<userData> getAllUsers()
        {
            return UserServiceImp.getAllUsers();
        }

       //Get User by ID
        @GetMapping("/user/{UserId}")
        public Optional<userData> getUser(@PathVariable long UserId)
        {
            return UserServiceImp.getUser(UserId);
        }

        //Create User
        @PostMapping("/user")
        public userData createUser(@RequestBody userData user)
        {
            UserServiceImp.createUser(user);
            return user;
        }

        //Update User using ID
        @PutMapping(value = "/user/{UserId}")
        public ResponseEntity<userData> update(@RequestBody userData user , @PathVariable("UserId") long UserId)
        {
           userData updtUser= UserRepository.findById(UserId).orElseThrow();
            UserServiceImp.updateUser(UserId,user,updtUser);
            return new ResponseEntity<userData>(HttpStatus.CREATED);
        }

        //Delete User using ID
        @DeleteMapping("/user/{UserId}")
        public ResponseEntity<userData> deleteById(@PathVariable("UserId") long UserId)
        {
            try
            {
                this.UserServiceImp.deleteUser(UserId);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}


