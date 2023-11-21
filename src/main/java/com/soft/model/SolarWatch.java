package com.soft.model;

public class SolarWatch extends Watch {

    private final String solarPanel;

    private SolarWatch(SolarWatchBuilder builder) {
        super(builder);
        this.solarPanel = builder.solarPanel;
    }

    public static SolarWatchBuilder builder() {
        return new SolarWatchBuilder() {
            @Override
            public SolarWatch build() {
                return new SolarWatch(this);
            }

            @Override
            protected SolarWatchBuilder self() {
                return this;
            }
        };
    }

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

    public static class SolarWatchBuilder extends Builder<SolarWatchBuilder> {

        private String solarPanel;

        public SolarWatchBuilder solarPanel(String solarPanel) {
            this.solarPanel = solarPanel;
            return self();
        }

        @Override
        public SolarWatch build() {
            return new SolarWatch(this);
        }

        @Override
        protected SolarWatchBuilder self() {
            return this;
        }
    }
}
