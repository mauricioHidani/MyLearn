package com.challenge.cdi;

import com.challenge.cdi.models.entities.Order;
import com.challenge.cdi.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class App implements CommandLineRunner {

    private OrderService orderService;

    public App(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final Set<Order> ORDERS = getOrders();

        ORDERS.forEach(order -> {
            print("Pedido codigo: %d", order.getCode());
            print("Valor total: R$ %.2f", orderService.total(order));
            print("\n");
        });
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void print(String message, Object... values) {
        System.out.printf(message + '\n', values);
    }

    private Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();
        orders.add(
            Order.builder()
                .code(1034)
                .basic(150.0)
                .discount(20.0)
            .build()
        );
        orders.add(
            Order.builder()
                .code(2282)
                .basic(800.0)
                .discount(10.0)
            .build()
        );
        orders.add(
            Order.builder()
                .code(1309)
                .basic(95.90)
                .discount(0.0)
            .build()
        );

        return orders;
    }
}
