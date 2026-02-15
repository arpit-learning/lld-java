package dev.arpit.BookMyShow.services;

import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public String hello(String name) {
        System.out.println("Hello, " + name);
        return "Hello, " + name;
    }
}
