package ru.stepagin.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay")
@CrossOrigin
public class PaymentController {

    @GetMapping("/pay/{payment_id}")
    public ResponseEntity getPaymentById(@PathVariable("payment_id") Long id) {
        try {
            // TODO: returns information about payment [and link for paying]
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

}