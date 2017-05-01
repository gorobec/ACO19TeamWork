package design_patterns.buider;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class MilkCreation {
    public static void main(String[] args) {
        Milk milk = new Milk.Builder().fats(15).
                minerals(15).setCarbohydrates(56).
                setE(123).setProteins(13).vitamins(1).
                water(700).volume(900).build();

        System.out.print(milk);
    }
}
