package design_patterns.observer;

import java.util.Observable;

/**
 * Created by gorobec on 27.05.17.
 */
public class FacebookPage extends Observable{


    private String name;

    public FacebookPage(String name) {
        this.name = name;
    }

    public void makePost(String post) {
        setChanged();
        notifyObservers(post);
    }

    public String getName() {
        return name;
    }
}
