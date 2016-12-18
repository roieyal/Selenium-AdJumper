package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static common.Utils.sleepRandom;

/**
 * Created by eyal on 15/12/2016.
 */
public class LoginArea {

    WebDriver driver;

    public LoginArea(WebDriver driver){
        this.driver = driver;
    }

    private static final By leftColumn = By.xpath(".//*[@id=\"mainIndex\"]/div[2]");
    private static final By loginArea = By.xpath(".//div[4]/form/div");
    private static final By loginEmailInput = By.xpath(".//*[@id=\"login_email\"]");
    private static final By loginPassword = By.xpath(".//*[@id=\"mockpass\"]/td/input");
    private static final By loginPasswordAfterClick = By.xpath(".//*[@id=\"Irealpass\"]");
    private static final By loginAreaEnterBtn = By.xpath(".//div[4]/form/div/table/tbody/tr[4]/td/input");


    public void selectUserEmailArea(){
        WebElement leftColumnArea = driver.findElement(leftColumn);
        leftColumnArea.findElement(loginEmailInput).click();
    }

    public void selectUserPasswordArea(){
        WebElement leftColumnArea = driver.findElement(leftColumn);
        leftColumnArea.findElement(loginPassword).click();
    }

    public void writeEmailInField(String email){
        WebElement leftColumnArea = driver.findElement(leftColumn);
        leftColumnArea.findElement(loginEmailInput).sendKeys(email);
    }

    public void writePassword(String password) {
        driver.findElement(loginPasswordAfterClick).sendKeys(password);
    }

    public void clickLoginOkBtn(){
        WebElement leftColumnArea = driver.findElement(leftColumn);
        leftColumnArea.findElement(loginAreaEnterBtn).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static By getLoginArea() {
        return loginArea;
    }

    public static By getLoginEmailInput() {
        return loginEmailInput;
    }

    public static By getLoginPassword() {
        return loginPassword;
    }

    public void logIn(String username, String password) {
        selectUserEmailArea();
        writeEmailInField(username);
        sleepRandom();
        selectUserPasswordArea();
        writePassword(password);
        sleepRandom();
        clickLoginOkBtn();
        sleepRandom();
    }
}
