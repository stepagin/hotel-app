package ru.stepagin.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stepagin.backend.DTO.ReservationData;

import java.util.Optional;

@RestController
@RequestMapping("/searchapp")
@CrossOrigin
public class SearchAppController {

    @GetMapping("/search")
    public ResponseEntity searchRooms(@RequestParam("occupied") Optional<String> dates,
                                      @RequestParam("adult_guests") Optional<String> adultGuests,
                                      @RequestParam("cheapest") Optional<String> cheapest,
                                      @RequestParam("lux") Optional<String> lux,
                                      @RequestParam("economy") Optional<String> economy,
                                      @RequestParam("price") Optional<String> price) {
        try {
            // TODO: firstly asks service for all rooms; filter format: dates(2), guestsAmount(int) and tags{}

            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity getRoomById(@PathVariable("id") Long id,
                                      @RequestParam("occupied") Optional<String> dates,
                                      @RequestParam("adult_guests") Optional<String> adultGuests) {
        try {
            // TODO: returns room, if it exists; if the dates and guests are set, returns price
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity reserveRoom(@PathVariable Long id, @RequestParam ReservationData data) {
        try {
            // TODO: firstly asks reservationService for reserve; requires dates and guests (ReservationData); redirect to paying
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время выполнения запроса");
        }
    }

}