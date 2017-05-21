package design_patterns.singleton;

/**
 * Created by gorobec on 21.05.17.
 */
public class EagerInitializationSingleton2 {
    private static EagerInitializationSingleton2 instance;

    static {
        instance = new EagerInitializationSingleton2();
    }

    private EagerInitializationSingleton2(){

    }

    public static EagerInitializationSingleton2 getInstance(){
        return instance;
    }

}
