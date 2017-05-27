package week8;

import java.util.List;

/**
 * Created by gorobec on 27.05.17.
 */
public class TestLambda {
    public static void main(String[] args) {
        LambdaClass lambdaClass = new LambdaClass();

        /*lambdaClass.act(new MyObserver() {
            @Override
            public void update() {

            }
        });*/

        lambdaClass.act(() ->
        {
            System.out.println("Update");
            return;}
        );
    }
}
