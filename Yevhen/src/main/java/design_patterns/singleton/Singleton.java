package design_patterns.singleton;

/**
 * Created by gorobec on 23.10.16.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }

}
