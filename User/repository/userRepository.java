package com.maaz.project.User.repository;

import com.maaz.project.User.data.userData;
import org.springframework.data.jpa.repository.JpaRepository;
public interface userRepository extends JpaRepository<userData, Long> {}


