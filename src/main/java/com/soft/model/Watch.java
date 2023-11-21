package com.soft.model;

import java.time.LocalDate;

/**
 * A model class representing a watch.
 */
public abstract class Watch {

    private Long id;
    private Long price;
    private Color color;
    private LocalDate arrivalDate;
    private Company company;


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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static abstract class Builder<T extends Builder<T>> {

        private Long id;
        private Long price;
        private Color color;
        private LocalDate arrivalDate;
        private Company company;

        public T id(Long id) {
            this.id = id;
            return self();
        }

        public T price(Long price) {
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
