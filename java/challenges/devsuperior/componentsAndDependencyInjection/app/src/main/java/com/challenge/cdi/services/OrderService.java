package com.challenge.cdi.services;

import com.challenge.cdi.models.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double tax = (order.getBasic() * (order.getDiscount() / 100));
        return order.getBasic() - tax + shippingService.shipment(order);
    }
}
