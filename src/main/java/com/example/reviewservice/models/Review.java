package com.example.reviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private Double rating;

//    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false)
//    private Booking booking; // we have defined a 1:1 relationship between booking and review
}
