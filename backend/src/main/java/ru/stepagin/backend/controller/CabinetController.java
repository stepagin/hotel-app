package ru.stepagin.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stepagin.backend.DTO.MessageContext;
import ru.stepagin.backend.DTO.NoticesParameters;
import ru.stepagin.backend.DTO.ReservationData;
import ru.stepagin.backend.DTO.UserPersonalData;
import ru.stepagin.backend.entity.ReservationEntity;
import ru.stepagin.backend.service.ReservationService;
import ru.stepagin.backend.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabinet")
@CrossOrigin
public class CabinetController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/profile/{id}")
    public ResponseEntity getProfileInfo(@PathVariable Long id) {
        try {
            UserPersonalData data = userService.getUserDataById(id);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/profile/edit")
    public ResponseEntity editProfileInfo(@RequestBody UserPersonalData data) {
        try {
            // TODO: gets profile id and rewrites profile info. Returns UserPersonalData
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/notices")
    public ResponseEntity getAllDialogsByUsername(@RequestBody Optional<NoticesParameters> parameters) {
        try {
            // TODO: needs JWT token. Gets filters from request. Returns all dialogs by username.
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/notices/{id}")
    public ResponseEntity getAllDialogMessages(@RequestBody NoticesParameters parameters, @PathVariable("id") Long id) {
        try {
            // TODO: returns messages at the dialog and information about reseravtion
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/notices/{id}/send")
    public ResponseEntity sendMessageAtDialog(@RequestBody MessageContext message, @PathVariable("id") Long id) {
        try {
            // TODO: saves message at DB, if it's possible
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/payments/history")
    public ResponseEntity getPaymentHistory(/* undone */) {
        try {
            // TODO: returns all payments (negative number) and refunds (positive number).
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/payments/invoices/{id}")
    public ResponseEntity getPaymentReceiptById(/* undone */) {
        try {
            // TODO: Uses JWT token. returns data about payment: reservation, amount and date
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/reservations")
    public ResponseEntity getAllReservations(@RequestBody UserPersonalData data) {
        try {
            ReservationService reservations = reservations.getReservationsByLogin(data.getLogin());
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/reservations/services/order")
    public ResponseEntity getAllServices(/* undone */) {
        try {
            // TODO: gets date, reservation id and orderType and returns created paymentId. After that redirect to payment -> and after that confirms order and redirect to orders (previous page).
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }
}
