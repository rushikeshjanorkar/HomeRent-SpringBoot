package com.HomeRent.rentApplication.Service;

import com.HomeRent.rentApplication.Entity.Admin;
import com.HomeRent.rentApplication.Entity.User;
import com.HomeRent.rentApplication.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    
    @Autowired
   private AdminRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public Admin registerAdmin(Admin admin){
        admin.setUsername(admin.getUsername());
        admin.setFullName(admin.getFullName());
        admin.setAddress(admin.getAddress());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setAddharNumber(admin.getAddharNumber());
        admin.setContactNumber(admin.getContactNumber());

        return adminRepository.save(admin);
        
    }

    public Admin login(Admin admin){

        Optional<Admin> userDetail = adminRepository.findByUsername(admin.getUsername());
        if (userDetail.isPresent() && passwordEncoder.matches(admin.getPassword(),userDetail.get().getPassword())){
            return userDetail.get();
        }
        throw new RuntimeException("Invalid username or password");
    }
    
}
