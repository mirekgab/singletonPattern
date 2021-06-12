package pl.mirekgab.singletonpattern;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("singleton test naive implementation");
        NaiveSingletonTest naiveSingletonTest = new NaiveSingletonTest();
        for (int a = 0; a < 10; a++) {
            naiveSingletonTest.test(a);
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println("\n\n-----------------------------------");
        System.out.println("singleton test");
        SingletonTest singletonTest = new SingletonTest();
        for (int a = 0; a < 10; a++) {
            singletonTest.test(a);
        }

    }

}
