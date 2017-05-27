package design_patterns.observer;

/**
 * Created by gorobec on 27.05.17.
 */
public class TestObserver {
    public static void main(String[] args) {
        FacebookPage facebookPage = new FacebookPage("Gromads'ke");

        Subscriber subscriber = new Subscriber();
        Subscriber subscriber2 = new Subscriber();
        Subscriber subscriber3 = new Subscriber();


        facebookPage.addObserver(subscriber);
        facebookPage.addObserver(subscriber2);
        facebookPage.addObserver(subscriber3);

        facebookPage.makePost("Bezviz");
    }
}
