package com.HomeRent.rentApplication.Controller;

import com.HomeRent.rentApplication.Entity.User;
import com.HomeRent.rentApplication.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user){
        userService.resgisteruser(user);
        return ResponseEntity.ok("User register successfully !!!");

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        userService.login(user);
        return ResponseEntity.ok("User Logged in successfully !!");
    }



}
