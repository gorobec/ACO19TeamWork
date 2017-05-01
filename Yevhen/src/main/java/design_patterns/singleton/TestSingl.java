package design_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by gorobec on 23.10.16.
 */
public class TestSingl {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();



        for (Constructor constructor : Singleton.class.getDeclaredConstructors()){
            constructor.setAccessible(true);
            Singleton singleton1 = (Singleton) constructor.newInstance();
            System.out.println(singleton1.hashCode());

        }

        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());


    }
}
