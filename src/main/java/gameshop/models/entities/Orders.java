package gameshop.models.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "game_in_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    List<Games> basket;

    Date orderDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Games> getBasket() {
        return basket;
    }

    public void setBasket(List<Games> basket) {
        this.basket = basket;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
