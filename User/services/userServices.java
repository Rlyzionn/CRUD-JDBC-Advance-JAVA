package com.maaz.project.User.services;

import com.maaz.project.User.data.userData;

import java.util.List;
import java.util.Optional;

public interface userServices
{


        public List<userData> getAllUsers();

        public Optional<userData> getUser(long UserId);

        public userData createUser(userData user);

        public userData  deleteUser(long x);

        public userData updateUser(long UserId, userData user, userData updUser);


    }
