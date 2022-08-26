package com.maaz.project.Admin.repository;

import com.maaz.project.Admin.data.adminData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepository extends JpaRepository<adminData, Long> {}
