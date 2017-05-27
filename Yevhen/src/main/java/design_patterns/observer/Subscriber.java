package design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by gorobec on 27.05.17.
 */
public class Subscriber implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        FacebookPage page = (FacebookPage)o;
        System.out.printf("%s add new post - %s\n", page.getName(), arg);
    }
}
