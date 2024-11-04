package com.HomeRent.rentApplication.Controller;

import com.HomeRent.rentApplication.Entity.Admin;
import com.HomeRent.rentApplication.Entity.User;
import com.HomeRent.rentApplication.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public ResponseEntity<String> register(@RequestBody @Valid Admin admin){
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("User register successfully !!!");

    }
    @PostMapping("/admin/login")
    public ResponseEntity<String> login(@RequestBody Admin admin){
        adminService.login(admin);
        return ResponseEntity.ok("User Logged in successfully !!");
    }
}
