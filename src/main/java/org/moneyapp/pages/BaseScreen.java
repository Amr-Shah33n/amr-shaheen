package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.moneyapp.ActionsManager;
import org.moneyapp.DriverManager;
import org.moneyapp.ScreenManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public abstract class BaseScreen extends LoadableComponent<BaseScreen> implements ScreenManager {
    protected static WebDriver driver;
    protected FluentWait<WebDriver> wait;
    private static final Logger LOGGER = LogManager.getLogger(BaseScreen.class);
    protected static ActionsManager actionsManager;

    public BaseScreen(boolean isLoaded) {
        driver = DriverManager.driver.get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        actionsManager = new ActionsManager(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        if (!isLoaded) {
            LOGGER.info("App is not on {} - explicitly loading screen..", this.getClass().getSimpleName());
            this.load();
        } else {
            LOGGER.info("App should be on {} -  asserting that screen was loaded..", this.getClass().getSimpleName());
        }
        this.get();
    }

    protected void load() {
        LOGGER.info("Loading {}", this.getClass().getSimpleName());
    }

    protected void isLoaded() {
        LOGGER.info("{} has been loaded!", this.getClass().getSimpleName());
    }

    public <T> T on(Class<T> screenClass, boolean isLoaded) {
        return ScreenManager.on(screenClass, isLoaded);
    }

}
