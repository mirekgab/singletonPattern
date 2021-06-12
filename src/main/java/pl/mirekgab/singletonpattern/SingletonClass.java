/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mirekgab.singletonpattern;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author mirek
 */
public final class SingletonClass {

    private static volatile SingletonClass instance;
    private String name;

    private SingletonClass(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this.name = name;
    }

    public static SingletonClass getInstance(String name) throws InterruptedException {
        SingletonClass result = instance;
        if (result != null) {
            return result;
        }

        synchronized (SingletonClass.class) {
            if (instance == null) {
                instance = new SingletonClass(name);
            }
            return instance;
        }
    }

    public String getName() {
        return this.name;
    }
}
