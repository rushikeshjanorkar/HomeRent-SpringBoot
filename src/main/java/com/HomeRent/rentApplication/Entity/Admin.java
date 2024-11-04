package com.HomeRent.rentApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Lob
    private byte[] photo;
    private String fullName;
    private String address;
    private String contactNumber;
    private Long adminId;
    private Long addharNumber;
    private String role = "ADMIN";

}
