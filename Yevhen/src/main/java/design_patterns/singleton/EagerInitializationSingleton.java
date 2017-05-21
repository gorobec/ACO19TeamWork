package design_patterns.singleton;

/**
 * Created by gorobec on 23.10.16.
 */
public class EagerInitializationSingleton {

    private static EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton(){

    }

    public static EagerInitializationSingleton getInstance(){
        return instance;
    }

}
