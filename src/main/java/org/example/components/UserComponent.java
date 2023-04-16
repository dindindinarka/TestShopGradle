package org.example.components;

import org.example.User;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserComponent {

    private final UserRepository userRepository ;

    public UserComponent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //private static List<User> listOfUsers = new ArrayList<>();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getOrCreateUser(String name, String phoneNumber) {

        var user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null)
            return user;
        else {
            var userNew = new User(name, phoneNumber);
            userRepository.save(userNew);
            return user;
        }
    }

    public User getUserIdByPhone(String phoneNumber) {
        var user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null)
            return user;
        else
                throw new NoSuchElementException(String.format("User with phone number '%s' not found", phoneNumber));
}
}
