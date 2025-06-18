package com.ramon.Desafio.services;

import com.ramon.Desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double shippingValue = shippingService.shipment(order);
        double discountResult = order.getBasic() * (order.getDiscount()/100.00);
        double orderBasic = order.getBasic();
        return orderBasic - discountResult + shippingValue;
    }
}
