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
public final class SingletonClassNaiveImplementation {

    private static volatile SingletonClassNaiveImplementation INSTANCE;
    private String name;

    private SingletonClassNaiveImplementation(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this.name = name;
    }

    public static SingletonClassNaiveImplementation getInstance(String name) throws InterruptedException {

        if (INSTANCE == null) {
            INSTANCE = new SingletonClassNaiveImplementation(name);
        }
        return INSTANCE;
    }

    public String getName() {
        return this.name;
    }
}
