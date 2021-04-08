package gameshop.controllers;

import gameshop.models.entities.Order;
import gameshop.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> index() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order save(@PathVariable long id, @RequestBody Order newOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrderDate(newOrder.getOrderDate());
                    order.setBasket(newOrder.getBasket());
                    order.setUser(newOrder.getUser());
                    return orderRepository.save(order);
                }).orElseGet(() -> null);
    }

    @DeleteMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        orderRepository.deleteById(id);
    }
}
