import common.BrowserType;
import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.LoginArea;
import ui.MainWindow;
import ui.PersonalAreaPage;

import java.io.File;
import java.util.UUID;

import static common.Utils.sleep;
import static common.Utils.sleepRandom;

/**
 * Created by eyal on 18/12/2016.
 */
public class MainClass {

    public static void main(String[] args) {

        WebDriver driver;

    /* All the instances should be created here */
        MainWindow mainWindow;
        UUID uuid = UUID.randomUUID();
        LoginArea loginArea;
        PersonalAreaPage personalAreaPage;

        // browser definitions are set here
        System.setProperty("webdriver.chrome.driver", "C:\\_Dev\\chromedriver.exe");
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(BrowserType.CHROME, new File("c:" + File.separator + "_Dev" + File.separator + "chromedriver.exe"), null, null);
        driver.get("http://www.yad2.co.il/");
        /* All the instances should be created here */
        mainWindow = new MainWindow(driver);
        loginArea = new LoginArea(driver);
        personalAreaPage = new PersonalAreaPage(driver);

        loginArea.selectUserEmailArea();
        loginArea.writeEmailInField("email");
        sleepRandom();
        loginArea.selectUserPasswordArea();
        loginArea.writePassword("password");
        sleepRandom();
        loginArea.clickLoginOkBtn();
        sleep(5);
        personalAreaPage.clickYad2Btn();
        personalAreaPage.clickOnTheFirstAdd();
        sleepRandom();
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"SearchButton\"]/table[4]/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/iframe"));
        driver.switchTo().frame(frame);
        personalAreaPage.clickHAKPATZA();

        if (personalAreaPage.checkIfHakpatzaEnabled()){
            System.out.println("your ad Hukpetza");
        }
        else {
            System.out.println("your ad was probably Hukpetza!!!");
        }
        driver.close();
        driver.quit();

    }

}

