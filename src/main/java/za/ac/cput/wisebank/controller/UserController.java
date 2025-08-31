package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.UserService;

import java.util.List;

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
    @PutMapping("/update")
    public User update (@RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteById (@PathVariable int id) {
        userService.deleteById(id);
    }
    @GetMapping("/read_user/{id}")
    public User findById (@PathVariable int id) {
        return userService.findById(id);
    }
    @GetMapping("/all_users")
    public List<User> findAll () {
        return userService.findAll();
    }
}

