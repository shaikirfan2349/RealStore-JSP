package com.example.Real_Store.repository;

import com.example.Real_Store.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
//    Admin findByAdmin(String adminName);
}
