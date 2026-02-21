package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.UserNotFoundException;
import dev.arpit.BookMyShow.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(int id) throws UserNotFoundException;
    User save(User user);
}
