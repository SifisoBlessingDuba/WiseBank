package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.dto.UserDTO;
import za.ac.cput.wisebank.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"}, allowCredentials = "true")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody User user) {
        User saved = userService.save(user);
        UserDTO body = UserDTO.from(saved);
        return ResponseEntity.created(URI.create("/user/read_user/" + saved.getIdNumber())).body(body);
    }

    @PutMapping("/change_password")
    public ResponseEntity<Map<String, Object>> changePassword(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String oldPassword = payload.get("oldPassword");
        String newPassword = payload.get("newPassword");

        if (email == null || oldPassword == null || newPassword == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("success", false, "message", "email, oldPassword and newPassword are required"));
        }

        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false, "message", "User not found"));
        }

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("success", false, "message", "Old password is incorrect"));
        }

        user.setPassword(newPassword); // will be encoded by service
        userService.save(user);

        return ResponseEntity.ok(Map.of("success", true, "message", "Password changed successfully"));
    }


    @PutMapping("/update")
    public ResponseEntity<UserDTO> update (@RequestBody User user) {
        User updated = userService.update(user);
        return ResponseEntity.ok(UserDTO.from(updated));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/read_user/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable String id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UserDTO.from(user));
    }

    @GetMapping("/all_users")
    public ResponseEntity<List<UserDTO>> findAll () {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<UserDTO> dtos = users.stream().map(UserDTO::from).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
//guys check if this page will show up in the final project
//15
