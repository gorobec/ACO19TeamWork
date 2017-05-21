package design_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by gorobec on 23.10.16.
 */
public class TestSingl {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        EagerInitializationSingleton eagerInitializationSingleton = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton eagerInitializationSingleton2 = EagerInitializationSingleton.getInstance();



        for (Constructor constructor : EagerInitializationSingleton.class.getDeclaredConstructors()){
            constructor.setAccessible(true);
            EagerInitializationSingleton eagerInitializationSingleton1 = (EagerInitializationSingleton) constructor.newInstance();
            System.out.println(eagerInitializationSingleton1.hashCode());

        }

        System.out.println(eagerInitializationSingleton.hashCode());
        System.out.println(eagerInitializationSingleton2.hashCode());


    }
}
