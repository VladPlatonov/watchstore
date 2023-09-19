package com.rolex.model.watches;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class QuartzWatch extends Watch {

    private String movement;

    @Override
    public String toString() {
        return "QuartzWatch{" +
            "id='" + getId() + '\'' +
            "movement='" + movement + '\'' +
            ", price=" + getPrice() +
            ", color='" + getColor() + '\'' +
            ", arrivalDate='" + getArrivalDate() + '\'' +
            '}';
    }

}
