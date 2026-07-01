package org.example.payment;

import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.model.PaymentResult;

public class PaymentProcessor {
    public PaymentResult process(Order order, PaymentMethod paymentMethod){
        if(order.getStatus() == OrderStatus.PAID){
            throw new IllegalStateException("Order is already paid.");
        }

        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot pay an empty order.");
        }

        PaymentResult result = paymentMethod.pay(order.calculateTotal());

        if(result.isSuccessful()){
            order.markAsPaid();
        }

        return result;
    }
}
