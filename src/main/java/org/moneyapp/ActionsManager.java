package org.moneyapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.List;

import static java.time.Duration.ZERO;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class ActionsManager {

    private final WebDriver driver;

    public ActionsManager(WebDriver driver) {
        this.driver = driver;
    }

    public void swipeRight() {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;
        Point startPoint = new Point(0, screenHeight / 2);
        Point endPoint = new Point(screenWidth / 2, screenHeight / 2);
        swipeBetweenTwoPoints(startPoint, endPoint);
    }

    public void goBack() {
        driver.navigate().back();
    }

    private void swipeBetweenTwoPoints(Point startPoint, Point endPoint) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll
                .addAction(finger.createPointerMove(ZERO, viewport(), startPoint.x, startPoint.y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), viewport(), endPoint.x, endPoint.y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(List.of(scroll));
    }
}
