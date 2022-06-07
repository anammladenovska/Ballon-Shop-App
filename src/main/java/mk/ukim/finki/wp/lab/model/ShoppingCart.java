package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.enumerations.ShoppingCartStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;


    @ManyToOne
    private User user;

    @ManyToMany
    private List<Order> orders;

    @ManyToMany
    private List<Balloon> balloons;


    @Enumerated(EnumType.STRING)
    public ShoppingCartStatus shoppingCartStatus;

    public ShoppingCart(User user) {
        this.user = user;
        this.dateCreated = LocalDateTime.now();
        this.orders = new ArrayList<>();
        this.shoppingCartStatus = ShoppingCartStatus.CREATED;

    }

    public ShoppingCart() {

    }
}
