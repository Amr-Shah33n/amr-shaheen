package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PromotionScreen extends BaseScreen {


    @AndroidFindBy(id = "buttonContinue")
    private WebElement firstPromoButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"AMAZING\")")
    private WebElement secondPromoButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"READY\")")
    private WebElement thirdPromoButton;

    @AndroidFindBy(id = "buttonClose")
    private WebElement promoButtonClose;
    
    public PromotionScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void load() {
        super.load();
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
    }
    
    protected void skipPromotion(){
        wait.until(visibilityOf(firstPromoButton)).click();
        wait.until(visibilityOf(secondPromoButton)).click();
        wait.until(visibilityOf(thirdPromoButton)).click();
        wait.until(elementToBeClickable(promoButtonClose)).click();
    }
    
    
}
