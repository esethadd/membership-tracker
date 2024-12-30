package com.membershipTracker.MembershipTracker.MemberAndAttendance.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity//Maps the "Object" to a Table in SQL
@Data
@Table(name = "members")//Declares the table name
public class Member {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generates our Ids (1 to n)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

}
