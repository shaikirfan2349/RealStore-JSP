package com.example.Real_Store.repository;

import com.example.Real_Store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUserName(String userName);
}
