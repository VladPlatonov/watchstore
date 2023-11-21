package com.soft.model;

public class QuartzWatch extends Watch {

    private final String movement;

    private QuartzWatch(QuartzWatchBuilder builder) {
        super(builder);
        this.movement = builder.movement;
    }

    public static QuartzWatchBuilder builder() {
        return new QuartzWatchBuilder() {
            @Override
            public QuartzWatch build() {
                return new QuartzWatch(this);
            }

            @Override
            protected QuartzWatchBuilder self() {
                return this;
            }
        };
    }

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

    public static class QuartzWatchBuilder extends Builder<QuartzWatchBuilder> {

        private String movement;

        public QuartzWatchBuilder movement(String movement) {
            this.movement = movement;
            return self();
        }

        @Override
        public QuartzWatch build() {
            return new QuartzWatch(this);
        }

        @Override
        protected QuartzWatchBuilder self() {
            return this;
        }
    }

}
