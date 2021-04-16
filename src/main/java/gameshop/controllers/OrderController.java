package gameshop.controllers;

import gameshop.models.entities.Game;
import gameshop.models.entities.Order;
import gameshop.models.repositories.OrderRepository;
import gameshop.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody List<Game> games, Authentication authentication) {
        Order order = new Order();
        order.setBasket(games);
        order.setOrderDate(new Date());
        order.setUser(userRepository.findByLogin(authentication.getName()).orElse(null));
        orderRepository.save(order);
    }
}
