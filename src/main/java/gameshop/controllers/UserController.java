package gameshop.controllers;

import gameshop.models.entities.Users;
import gameshop.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> index() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users Users) {
        return userRepository.save(Users);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users save(@PathVariable long id, @RequestBody Users newUsers) {
        return userRepository.findById(id)
                .map(users -> {
                    users.setLogin(newUsers.getLogin());
                    users.setPassword(newUsers.getPassword());
                    users.setRole(newUsers.getRole());
                    return userRepository.save(users);
                }).orElseGet(() -> null);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
