package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by mendelan on 11/10/2016.
 */
public class WebDriverFactory {

    private final Logger logger = Logger.getLogger(getClass().getName());


    public WebDriver createWebDriver(BrowserType browserType, File driverFile, File logFile, File downloadFolder) {
        logger.info("Creating " + browserType + " webDriver...");
        WebDriver webDriver = null;
        switch (browserType) {
            case CHROME:
                webDriver = createLocalChromeWebDriver(driverFile, logFile, downloadFolder);
                break;

            default:
                logger.severe("Selected browser type not supported.");
                break;
        }
        logger.info("Done.");
        return webDriver;
    }


    /**
     * Chrome
     */
    public WebDriver createLocalChromeWebDriver(File driverFile, File logFile, File downloadFolder) {
        return createLocalChromeWebDriver(driverFile, logFile, getDefChromeOptions(downloadFolder));
    }

    public WebDriver createLocalChromeWebDriver(File driverFile, File logFile, ChromeOptions chromeOptions) {
        long startTimeMillis = System.currentTimeMillis(); //to calculate browser open time
        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
        ChromeDriverService service;

        if (logFile != null) {
            logger.info("WebDriver logging enabled; File: " + logFile.getAbsolutePath());
            service =
                    builder
                            .usingDriverExecutable(driverFile)
                            .usingAnyFreePort()
                            .withLogFile(logFile)
                            .build();
        } else {
            logger.info("WebDriver logging disabled.");
            service =
                    builder
                            .usingDriverExecutable(driverFile)
                            .usingAnyFreePort()
                            .build();
        }

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        ChromeDriver driver = new ChromeDriver(service, caps);
        logger.info("ChromeDriver creation took: " + ((System.currentTimeMillis() - startTimeMillis) / 1000) + " seconds.");
        return driver;
    }

    public ChromeOptions getDefChromeOptions(File downloadFolder) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-memory-info");
        options.addArguments("--test-type");
        options.addArguments("--incognito");

        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("download.default_directory", downloadFolder.getAbsolutePath());
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        return options;
    }
    /**
     * Chrome end
     */

}
