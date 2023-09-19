package com.rolex.model.watches;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SolarWatch extends Watch{

    private String solarPanel;

    @Override
    public String toString() {
        return "SolarWatch{" +
            "id='" + getId() + '\'' +
            "solarPanel='" + solarPanel + '\'' +
            ", price=" + getPrice() +
            ", color='" + getColor() + '\'' +
            ", arrivalDate='" + getArrivalDate() + '\'' +
            '}';
    }

}
