package gameshop.controllers;

import gameshop.models.entities.User;
import gameshop.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User User) {
        return userRepository.save(User);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User save(@PathVariable long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setLogin(newUser.getLogin());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());
                    return userRepository.save(user);
                }).orElseGet(() -> null);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
