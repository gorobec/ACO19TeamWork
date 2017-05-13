package design_paterns.builder;

public class Milk {
    private final int fats;
    private final int proteins;
    private final int carbohydrate;
    private final int vitamins;
    private final int e;
    private final int minirals;
    private final int volume;
    private final int water;

    private Milk(Builder builder) {
        this.fats = builder.fats;
        this.proteins = builder.proteins;
        this.carbohydrate = builder.carbohydrate;
        this.vitamins = builder.vitamins;
        this.e = builder.e;
        this.minirals = builder.minirals;
        this.volume = builder.volume;
        this.water = builder.water;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "fats=" + fats +
                ", proteins=" + proteins +
                ", carbohydrate=" + carbohydrate +
                ", vitamins=" + vitamins +
                ", e=" + e +
                ", minirals=" + minirals +
                ", volume=" + volume +
                ", water=" + water +
                '}';
    }

    public static class Builder{
        private int fats;
        private int proteins;
        private int carbohydrate;
        private int vitamins;
        private int e;
        private int minirals;
        private int volume;
        private int water;

        public Builder setFats(int fats) {
            this.fats = fats;
            return this;
        }

        public Builder setProteins(int proteins) {
            this.proteins = proteins;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public Builder setVitamins(int vitamins) {
            this.vitamins = vitamins;
            return this;
        }

        public Builder setE(int e) {
            this.e = e;
            return this;
        }

        public Builder setMinirals(int minirals) {
            this.minirals = minirals;
            return this;
        }

        public Builder setVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public Builder setWater(int water) {
            this.water = water;
            return this;
        }

        public Milk Build(){
            return new Milk(this);
        }
    }
}
