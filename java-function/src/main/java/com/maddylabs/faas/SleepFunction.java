package com.maddylabs.faas;


import static java.text.MessageFormat.format;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mageshwaranr on 5/17/2017.
 *
 * Sleeps by default multiple of a minutes.
 */
public class SleepFunction {

    public static void main(String[] args) throws InterruptedException {

        int i = new Random().nextInt(5);
        i++;
        System.out.println(format("Sleeping for {0} minutes",i));
        Thread.sleep(TimeUnit.MINUTES.toMillis(i));
        System.out.println("Completing the process");
    }
}
