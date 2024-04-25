package com.example.reviewservice.repositories;

import com.example.reviewservice.models.Booking;
import com.example.reviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
