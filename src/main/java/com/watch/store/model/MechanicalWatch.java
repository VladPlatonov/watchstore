package com.watch.store.model;

public class MechanicalWatch extends Watch {

    private final String movement;

    private MechanicalWatch(MechanicalWatchBuilder builder) {
        super(builder);
        this.movement = builder.movement;
    }

    public static MechanicalWatchBuilder builder() {
        return new MechanicalWatchBuilder() {
            @Override
            public MechanicalWatch build() {
                return new MechanicalWatch(this);
            }

            @Override
            protected MechanicalWatchBuilder self() {
                return this;
            }
        };
    }

    @Override
    public String toString() {
        return "MechanicalWatch{" +
            "id='" + getId() + '\'' +
            ", company='" + getCompany() + '\'' +
            ", movement='" + movement + '\'' +
            ", price=" + getPrice() +
            ", color='" + getColor() + '\'' +
            ", arrivalDate='" + getArrivalDate() + '\'' +
            '}';
    }

    public static class MechanicalWatchBuilder extends Builder<MechanicalWatchBuilder> {

        private String movement;

        public MechanicalWatchBuilder movement(String movement) {
            this.movement = movement;
            return self();
        }

        @Override
        public MechanicalWatch build() {
            return new MechanicalWatch(this);
        }

        @Override
        protected MechanicalWatchBuilder self() {
            return this;
        }
    }
}

