package ru.stepagin.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stepagin.backend.DTO.LoginContext;
import ru.stepagin.backend.DTO.UserPersonalData;
import ru.stepagin.backend.entity.AccountEntity;
import ru.stepagin.backend.service.AccountService;

@Controller
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody AccountEntity loginData) {
        try {
            UserPersonalData user = accountService.login(loginData.getLogin(), loginData.getPassword());
            if (user == null)
                return ResponseEntity.badRequest().body(new LoginContext());
            else
                return ResponseEntity.ok(new LoginContext(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody AccountEntity loginData) {
        try {
            UserPersonalData user = accountService.register(loginData.getLogin(), loginData.getPassword());
            if (user == null)
                return ResponseEntity.badRequest().body(new LoginContext());
            else
                return ResponseEntity.ok(new LoginContext(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

}
