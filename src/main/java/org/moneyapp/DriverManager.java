package org.moneyapp;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.moneyapp.URLRetriever.URLs.BROWSER_STACK_APPIUM_SERVER;


public class DriverManager {

    public static ThreadLocal<AppiumDriver> driver = ThreadLocal.withInitial(DriverManager::init);
    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

    public static AppiumDriver init() {
        LOGGER.info("Initializing Appium driver");
        AppiumDriver driver = new AppiumDriver(URLRetriever.getUrlFromString(BROWSER_STACK_APPIUM_SERVER), new DesiredCapabilities());
        LOGGER.info("Appium driver session {} has been initialized successfully", driver.getSessionId());
        return driver;
    }

    public static void tearDown() {
        LOGGER.info("Tearing down Appium driver");
        driver.get().quit();
        driver.remove();
        LOGGER.info("Appium driver has been torn down");
    }
}
