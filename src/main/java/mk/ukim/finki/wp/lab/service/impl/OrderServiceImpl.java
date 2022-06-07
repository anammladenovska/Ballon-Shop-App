package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.repository.impl.InMemoryOrderRepository;
import mk.ukim.finki.wp.lab.repository.jpa.OrderRepository;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order placeOrder(String balloonColor, String balloonSize,  Long orderId,String username) {
        Order order = new Order(balloonColor, balloonSize,orderId,username);
        orderRepository.save(order); //ne sum sigurna dali mozit vaka, bidejki mi trebit da gi dodavat site naracani, ova gi zacuvuvat?
        return order;
    }

    @Override
    public List<Order> listOrderBalloon() {
        return orderRepository.findAll();
    }
}
