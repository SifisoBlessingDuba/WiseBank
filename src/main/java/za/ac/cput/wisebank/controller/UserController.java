package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"}, allowCredentials = "true")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        User user = userService.findById(email); // you need to add this method in UserService
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/update")
    public User update (@RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteById (@PathVariable String id) {
        userService.deleteById(id);
    }
    @GetMapping("/read_user/{id}")

    public User findById (@PathVariable String id) {
        return userService.findById(id);
    }
    @GetMapping("/all_users")
    public List<User> findAll () {
        return userService.findAll();
    }
}

