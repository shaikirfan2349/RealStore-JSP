package com.example.Real_Store.repository;

import com.example.Real_Store.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Booking,Long> {
}
