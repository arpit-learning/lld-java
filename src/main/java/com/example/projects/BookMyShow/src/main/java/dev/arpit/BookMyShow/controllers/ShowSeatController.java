package dev.arpit.BookMyShow.controllers;

import dev.arpit.BookMyShow.services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowSeatController {
    @Autowired
    private ShowSeatService showSeatService;

//    @PostMapping("/show-seat")
//    public void crateShowSeat() {
//
//    }
}
