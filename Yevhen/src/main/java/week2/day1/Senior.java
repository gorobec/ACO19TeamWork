package week2.day1;

/**
 * Created by gorobec on 08.04.17.
 */
public class Senior extends Coder {
    public Senior(String name, String surname, int age, String language) {
        super(name, surname, age, language);
    }

    @Override
    public void work() {
        System.out.print("I'm senior. ");
    }

    @Override
    public void test() {

    }
}
