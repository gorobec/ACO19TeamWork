package design_patterns.adapter;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestAdapter {


    public static void main(String[] args) {
        PoliceDepartment policeDepartment = new PoliceDepartment();

        Policeman policeman1 = new Policeman("Jonh", 32);
        Policeman policeman2 = new Policeman("Bill", 35);
        Militioner militioner = new Militioner("Dan", 50);

        policeDepartment.addPoliceman(policeman1);
        policeDepartment.addPoliceman(policeman2);
        policeDepartment.addPoliceman(new PolicemanAdapter(militioner));

        policeDepartment.startWorkingDay();
    }




}
