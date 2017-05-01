package design_patterns.singleton;

/**
 * Created by gorobec on 23.10.16.
 */
public class LazySingleton {

    private static LazySingleton instance;


    private LazySingleton(){

    }

    public LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
