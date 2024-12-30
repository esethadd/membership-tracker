package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "attendance")
public class Attendance {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generates our Ids (1 to n)
    @Column(name = "attendance_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")//Joins our memberId column in attendance table to our id in member's table
     private Member members;


    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;


}
