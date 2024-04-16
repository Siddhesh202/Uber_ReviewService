package com.example.reviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    // 1 : N association
    // 1 Driver has many bookings
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}