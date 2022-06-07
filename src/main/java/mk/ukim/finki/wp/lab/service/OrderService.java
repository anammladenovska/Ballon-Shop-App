package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String balloonColor,String balloonSize, Long orderId,String username);
    List<Order> listOrderBalloon();
}
