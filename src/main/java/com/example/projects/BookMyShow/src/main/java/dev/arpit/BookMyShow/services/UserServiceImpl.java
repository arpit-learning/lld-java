package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.UserNotFoundException;
import dev.arpit.BookMyShow.models.User;
import dev.arpit.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with " + id + " not found", ResponseCode.ER_400, "User not found"));
    }
}
