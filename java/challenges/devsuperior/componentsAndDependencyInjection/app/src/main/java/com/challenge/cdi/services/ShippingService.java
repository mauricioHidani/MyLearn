package com.challenge.cdi.services;

import com.challenge.cdi.models.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double shipment = 0.0d;
        double basic = order.getBasic();

        if (basic < 100) {
            shipment = 20d;
        }
        else if (basic >= 100 && basic < 200) {
            shipment = 12d;
        }
        else {
            shipment = 0d;
        }

        return shipment;
    }
}
