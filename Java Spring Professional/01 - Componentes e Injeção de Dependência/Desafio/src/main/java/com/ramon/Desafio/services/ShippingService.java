package com.ramon.Desafio.services;

import com.ramon.Desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment (Order order){
        double result = 0.00;
        if (order.getBasic() < 100.00){
            result = 20.00;
        } else if (order.getBasic() >= 100.00 && order.getBasic() < 200.00){
            result = 12.00;
        } else {
            result = 0.00;
        }
        return result;
    }
}
