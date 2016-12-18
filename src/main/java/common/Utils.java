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

    public static void sleepRandom(){
        try {
            int randomNum = randInt(1, 10);
            Thread.sleep(randomNum*1000);                 //x milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static int randInt(int min, int max) {
        min = 1;
        max = 10;
        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
}
