package com.HomeRent.rentApplication.Controller;

import com.HomeRent.rentApplication.Entity.Admin;
import com.HomeRent.rentApplication.Repository.AdminRepository;
import com.HomeRent.rentApplication.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/admin")
    public ResponseEntity<String> register(@RequestBody @Valid Admin admin){
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("User register successfully !!!");

    }
    @PostMapping("/admin/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin){
       Admin admin1 = adminService.login(admin);
        return ResponseEntity.ok(admin1);
    }

    @GetMapping("/admin/{id}")
    public Optional<Admin> adminid(@PathVariable Long id){
        return adminRepository.findById(id);
    }
}
