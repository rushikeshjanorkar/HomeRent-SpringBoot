package SpringBoot.HomeRentApplication.Controller;

import SpringBoot.HomeRentApplication.Entity.Admin;
import SpringBoot.HomeRentApplication.Repository.AdminRepository;
import SpringBoot.HomeRentApplication.Service.AdminService;
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
