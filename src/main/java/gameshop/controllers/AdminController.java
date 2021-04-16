package gameshop.controllers;

import gameshop.models.entities.Game;
import gameshop.models.entities.Genre;
import gameshop.models.entities.Order;
import gameshop.models.entities.User;
import gameshop.models.repositories.GameRepository;
import gameshop.models.repositories.GenreRepository;
import gameshop.models.repositories.OrderRepository;
import gameshop.models.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Secured("ROLE_ADMIN")
public class AdminController {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game) {
        game.setSold(0);
        return gameRepository.save(game);
    }

    @PutMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game save(@PathVariable long id, @RequestBody Game newGame) {
        return gameRepository.findById(id)
                .map(game -> {
                    BeanUtils.copyProperties(newGame, game, "id");
                    return gameRepository.save(game);
                }).orElse(null);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable long id) {
        gameRepository.deleteById(id);
    }


    @GetMapping("/genres")
    public List<Genre> index() {
        return genreRepository.findAll();
    }


    @GetMapping("/orders")
    public List<Order> indexOrders() {
        return orderRepository.findAll();
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order save(@PathVariable long id, @RequestBody Order newOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    BeanUtils.copyProperties(newOrder, order, "id");
                    return orderRepository.save(order);
                }).orElse(null);
    }

    @DeleteMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable long id) {
        orderRepository.deleteById(id);
    }


    @GetMapping("/users")
    public List<User> indexUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User save(@PathVariable long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    BeanUtils.copyProperties(newUser, user, "id");
                    user.setPassword(encoder.encode(user.getPassword()));
                    return userRepository.save(user);
                }).orElse(null);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
