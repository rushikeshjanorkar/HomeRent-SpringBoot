package SpringBoot.HomeRentApplication.Controller;

import SpringBoot.HomeRentApplication.Entity.User;
import SpringBoot.HomeRentApplication.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user){
        userService.resgisteruser(user);
        return ResponseEntity.ok("User register successfully !!!");

    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
       User user1 = userService.login(user);
        return ResponseEntity.ok(user1);
    }



}
