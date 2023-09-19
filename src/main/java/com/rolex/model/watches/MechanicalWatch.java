package com.rolex.model.watches;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class MechanicalWatch extends Watch {

    private String movement;

    @Override
    public String toString() {
        return "MechanicalWatch{" +
            "id='" + getId() + '\'' +
            "movement='" + movement + '\'' +
            ", price=" + getPrice() +
            ", color='" + getColor() + '\'' +
            ", arrivalDate='" + getArrivalDate() + '\'' +
            '}';
    }

}
