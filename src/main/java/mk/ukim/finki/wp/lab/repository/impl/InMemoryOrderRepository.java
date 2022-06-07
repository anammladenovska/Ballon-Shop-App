package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderRepository {

    public List<Order> orders;

    public InMemoryOrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> orderList(){
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }
}
