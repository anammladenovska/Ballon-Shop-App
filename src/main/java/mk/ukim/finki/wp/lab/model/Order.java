package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity(name = "shop.orders")
public class Order {

    @Id
    private Long orderId;
    private String balloonColor;
    private String balloonSize;

    @ManyToOne
    User user = new User();
    private String username = getUsername();



//    public Order(String balloonColor, String balloonSize, Long orderId) {
//        this.balloonColor = balloonColor;
//        this.balloonSize = balloonSize;
//        this.orderId=orderId;
//    }

    public Order( String balloonColor, String balloonSize,Long orderId, String username) {
        this.orderId = orderId;
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.username=username;
    }

    public Order() {

    }
}
