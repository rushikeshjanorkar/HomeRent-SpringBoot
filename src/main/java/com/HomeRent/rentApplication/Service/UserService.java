package com.HomeRent.rentApplication.Service;


import com.HomeRent.rentApplication.Entity.User;
import com.HomeRent.rentApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User resgisteruser(User user){
        user.setUsername(user.getUsername());
        user.setFullName(user.getFullName());
        user.setAddress(user.getAddress());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddharNumber(user.getAddharNumber());
        user.setContactNumber(user.getContactNumber());

       return userRepository.save(user);
    }

    public User login(User user){

        Optional<User> userDetail = userRepository.findByUsername(user.getUsername());
        if (userDetail.isPresent() && passwordEncoder.matches(user.getPassword(),userDetail.get().getPassword())){
            return userDetail.get();
        }
        throw new RuntimeException("Invalid username or password");
    }

}
