package design_patterns.singleton;

/**
 * Created by gorobec on 23.10.16.
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;


    private ThreadSafeSingleton(){

    }

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
