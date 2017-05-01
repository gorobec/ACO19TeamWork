package design_patterns.buider;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Milk {
    private final int fats;
    private final int proteins;
    private final int carbohydrates;
    private final int vitamins;
    private final int e;
    private final int volume;
    private final int water;
    private final int minerals;


    private Milk(Builder builder) {
        this.fats = builder.fats;
        this.proteins = builder.proteins;
        this.carbohydrates = builder.carbohydrates;
        this.vitamins = builder.vitamins;
        this.e = builder.e;
        this.volume = builder.volume;
        this.water = builder.water;
        this.minerals = builder.minerals;
    }

    public static class Builder {
        private int fats;
        private int proteins;
        private int carbohydrates;
        private int vitamins;
        private int e;
        private int volume;
        private int water;
        private int minerals;

        public Builder fats(int fats) {
            this.fats = fats;
            return this;
        }

        public Builder setProteins(int proteins) {
            this.proteins = proteins;
            return this;
        }

        public Builder setCarbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Builder vitamins(int vitamins) {
            this.vitamins = vitamins;
            return this;
        }

        public Builder setE(int e) {
            this.e = e;
            return this;
        }

        public Builder volume(int volume) {
            this.volume = volume;
            return this;
        }

        public Builder water(int water) {
            this.water = water;
            return this;
        }

        public Builder minerals(int minerals) {
            this.minerals = minerals;
            return this;
        }

        public Milk build(){
            return new Milk(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Milk{");
        sb.append("fats=").append(fats);
        sb.append(", proteins=").append(proteins);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append(", vitamins=").append(vitamins);
        sb.append(", e=").append(e);
        sb.append(", volume=").append(volume);
        sb.append(", water=").append(water);
        sb.append(", minerals=").append(minerals);
        sb.append('}');
        return sb.toString();
    }
}
