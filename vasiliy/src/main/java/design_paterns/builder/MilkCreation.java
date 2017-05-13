package design_paterns.builder;

public class MilkCreation {
    public static void main(String[] args) {
        Milk milk = new Milk.Builder().setFats(10).setProteins(15).setVolume(1000).Build();

        System.out.println(milk);
    }

}
