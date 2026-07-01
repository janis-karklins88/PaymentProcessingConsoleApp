package org.example.repository;

import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> completedOrders = new ArrayList<>();

    public void save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order must be provided.");
        }
        if (!order.isPaid()) {
            throw new IllegalArgumentException("Only paid orders can be saved.");
        }

        completedOrders.add(order);
    }

    public List<Order> findAll() {
        return List.copyOf(completedOrders);
    }
}
