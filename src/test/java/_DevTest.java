import common.BrowserType;
import common.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ui.LoginArea;
import ui.MainWindow;
import ui.PersonalAreaPage;

import java.io.File;
import java.util.UUID;


/**
 * Created by eyal on 24/11/2016.
 */
public class _DevTest {

    private WebDriver driver;

    /* All the instances should be created here */
    MainWindow mainWindow;
    UUID uuid = UUID.randomUUID();
    LoginArea loginArea;
    PersonalAreaPage personalAreaPage;

    @Before
    public void setup() {
        // browser definitions are set here
        System.setProperty("webdriver.chrome.driver", "C:\\_Dev\\chromedriver.exe");
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(BrowserType.CHROME, new File("c:" + File.separator + "_Dev" + File.separator + "chromedriver.exe"), null, null);
        driver.get("http://www.yad2.co.il/");
        /* All the instances should be created here */
        mainWindow = new MainWindow(driver);
        loginArea = new LoginArea(driver);
        personalAreaPage = new PersonalAreaPage(driver);
    }

    @Ignore
    @Test
    public void jumpAllPersonalAdsTest() {

        loginArea.logIn("username", "password");
        personalAreaPage.clickYad2Btn();
        personalAreaPage.jumpAllAds();
    }

    @Ignore
    @Test
    public void chromeTest2() {
    }

    @After
    public void cleanup() {
        driver.close();
        driver.quit();

    }
}
