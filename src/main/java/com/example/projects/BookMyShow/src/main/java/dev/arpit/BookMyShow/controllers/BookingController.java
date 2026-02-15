package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/hello/{name}")
    private String hello(@PathVariable("name") String name) {
        return bookingService.hello(name);
    }
}
