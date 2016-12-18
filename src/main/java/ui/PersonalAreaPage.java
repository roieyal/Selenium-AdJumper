package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static common.Utils.sleep;

/**
 * Created by eyal on 15/12/2016.
 */
public class PersonalAreaPage {
    //*[@id="SearchButton"]                    PAGE LOCATOR

    WebDriver driver;

    public PersonalAreaPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By yad2Btn = By.xpath(".//*[@id=\"SearchButton\"]/table[2]/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td[3]/a/img");
    private static final By firstAdd = By.xpath("//*[@id=\"ActiveLink\"]/td[5]");
    private static final By secondAdd = By.xpath("//*[@id=\"SearchButton\"]/table[4]/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[5]");
    private static final By HakpatzaBtnNotEnabled = By.xpath(".//html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/img");
    private static final By HakpatzaBtn = By.xpath(".//html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/a");

    public void clickYad2Btn(){
        sleep(10);
        driver.findElement(yad2Btn).click();
    }

    public void clickOnTheFirstAdd(){
        sleep(3);
        driver.findElement(firstAdd).click();
    }

    public boolean checkIfHakpatzaEnabled(){
        try {
            driver.findElement(HakpatzaBtnNotEnabled).isDisplayed();
        }
        catch (Exception e){
            System.out.println("Hakpatza button is probably not enabled anymore...");
        }
        return false;
    }

    public void clickHAKPATZA(){
        try {
            sleep(3);
            driver.findElement(HakpatzaBtn).click();
        }
        catch (Exception e){
            try {
                driver.findElement(HakpatzaBtnNotEnabled).isDisplayed();
            }
            catch (Exception f){
                System.out.println("The Add was not hukpetza might be related to the time frame every 4 hours");
            }
        }
    }
}
