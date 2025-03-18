package org.moneyapp.pages;

import io.appium.java_client.pagefactory.*;
import org.moneyapp.enums.ExpenseCategories;
import org.moneyapp.enums.IncomeSources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class SpecifyAmountScreen extends BaseScreen {

    @AndroidFindBy(id = "keyboard_action_button")
    private WebElement chooseCategoryButton;

    public SpecifyAmountScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void load() {
        super.load();
    }

    @Override
    protected void isLoaded() throws Error {
        wait.until(visibilityOfAllElements(chooseCategoryButton));
        super.isLoaded();
    }

    public SpecifyAmountScreen enterAmount(String amount) {
        for (int i = 0; i < amount.length(); i++) {
            driver.findElement(By.id("buttonKeyboard" + amount.charAt(i))).click();
        }
        return this;
    }

    public SpecifyAmountScreen chooseCategory() {
        chooseCategoryButton.click();
        return this;
    }

    public SpecifyAmountScreen selectExpenseCategory(ExpenseCategories category) {
        wait.until(
                elementToBeClickable(androidUIAutomator(
                                format("new UiSelector().textContains(\"%s\")", category.getDisplayName())
                        )
                )
        ).click();
        return this;
    }

    public SpecifyAmountScreen selectIncomeSource(IncomeSources source) {
        wait.until(
                elementToBeClickable(androidUIAutomator(
                                format("new UiSelector().textContains(\"%s\")", source.getDisplayName())
                        )
                )
        ).click();
        return this;
    }
}
