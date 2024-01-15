package ru.stepagin.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stepagin.backend.entity.AccountEntity;

@Controller
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody AccountEntity user) {
        try {
            // TODO: gets login and password and login user. Returns boolean flag, user data, role[, jwt token]
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("");
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody AccountEntity user) {
        try {
            // TODO: gets login and password and register user. Returns boolean flag, user data[, jwt token] set role 'guest' as default
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("");
        }
    }

}
