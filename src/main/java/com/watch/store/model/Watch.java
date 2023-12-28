package com.watch.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A model class representing a watch.
 */
public abstract class Watch {

    private final BigDecimal price;
    private final Color color;
    private final LocalDate arrivalDate;
    private final Company company;
    private Long id;

    public Watch(Builder<?> builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.color = builder.color;
        this.arrivalDate = builder.arrivalDate;
        this.company = builder.company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Company getCompany() {
        return company;
    }

    public static abstract class Builder<T extends Builder<T>> {

        private Long id;
        private BigDecimal price;
        private Color color;
        private LocalDate arrivalDate;
        private Company company;

        public T id(Long id) {
            this.id = id;
            return self();
        }

        public T price(BigDecimal price) {
            this.price = price;
            return self();
        }

        public T color(Color color) {
            this.color = color;
            return self();
        }

        public T arrivalDate(LocalDate arrivalDate) {
            this.arrivalDate = arrivalDate;
            return self();
        }

        public T company(Company company) {
            this.company = company;
            return self();
        }

        public abstract Watch build();

        protected abstract T self();
    }

}
