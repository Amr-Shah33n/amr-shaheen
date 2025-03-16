package org.moneyapp;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;;
import java.net.URL;
import java.util.HashMap;

public class DriverManager {

    public static ThreadLocal<AppiumDriver> driver = ThreadLocal.withInitial(DriverManager::init);
    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

    public static AppiumDriver init() {
        LOGGER.info("Initializing Appium driver");
        DesiredCapabilities caps = new DesiredCapabilities();
       /* HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("sessionName", "my_test_session");
        caps.setCapability("bstack:options", bstackOptions);*/
        URL serevrURL;
        try {
             serevrURL = new URL("https://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        AppiumDriver driver = new AppiumDriver(serevrURL, caps);
        LOGGER.info("Appium driver session {} has been initialized successfully", driver.getSessionId());
        return driver;    }

    public static void tearDown() {
        LOGGER.info("Tearing down Appium driver");
        driver.get().quit();
        driver.remove();
        LOGGER.info("Appium driver has been torn down");
    }
}
