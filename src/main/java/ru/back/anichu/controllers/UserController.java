package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.Anime;
import ru.back.anichu.models.User;
import ru.back.anichu.repositories.UserRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setWillWatchAnimeList(newUser.getWillWatchAnimeList());
            user.setWatchAnimeList(newUser.getWatchAnimeList());
            user.setWatchedAnimeList(newUser.getWatchedAnimeList());
            return userRepository.save(user);
        }).orElse(null);
    }

    @PatchMapping("/users/{id}")
    User patchUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setWillWatchAnimeList(newUser.getWillWatchAnimeList());
            user.setWatchAnimeList(newUser.getWatchAnimeList());
            user.setWatchedAnimeList(newUser.getWatchedAnimeList());
            return userRepository.save(user);
        }).orElse(null);
    }

    @PostMapping("/users")
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
