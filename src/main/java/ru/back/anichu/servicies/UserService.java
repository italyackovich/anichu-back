package ru.back.anichu.servicies;

import ru.back.anichu.models.User;
import ru.back.anichu.repositories.UserRepository;

import java.util.List;

public class UserService {

    private static UserRepository userRepository;


    public static User postUser(User user) {
        return userRepository.save(user);
    }

    public static User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public static List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public static void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public static User putUser(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElse(null);
    }

}
