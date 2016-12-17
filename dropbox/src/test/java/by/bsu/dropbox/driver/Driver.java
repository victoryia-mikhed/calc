package by.bsu.dropbox.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Driver {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_GECKODRIVER_EXE_PATH = ".\\geckodriver\\geckodriver.exe";

    private Driver() {
    }


    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_GECKODRIVER_EXE_PATH);
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            logger.info("Browser started");
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
