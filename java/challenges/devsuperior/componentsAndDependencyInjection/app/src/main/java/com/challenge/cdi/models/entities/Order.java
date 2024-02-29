package com.challenge.cdi.models.entities;

import java.io.Serial;
import java.io.Serializable;

public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private Double basic;
    private Double discount;

    protected Order() {

    }

    public Order(Integer code, Double basic, Double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public Double getBasic() {
        return basic;
    }

    public Double getDiscount() {
        return discount;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {

        private Integer code;
        private Double basic;
        private Double discount;

        public OrderBuilder code(Integer code) {
            this.code = code;
            return this;
        }

        public OrderBuilder basic(Double basic) {
            this.basic = basic;
            return this;
        }

        public OrderBuilder discount(Double discount) {
            this.discount = discount;
            return this;
        }

        public Order build() {
            return new Order(
                    code,
                    basic,
                    discount
            );
        }
    }
}
