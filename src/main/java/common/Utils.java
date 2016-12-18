package common;

import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by eyal on 29/11/2016.
 */
public class Utils {

       public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepRandom() {
        sleepRandom(1, 10);
    }

    public static void sleepRandom(int min, int max){
        try {
            int randomNum = randInt(min, max);
            Thread.sleep(randomNum*1000);                 //x milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
}
