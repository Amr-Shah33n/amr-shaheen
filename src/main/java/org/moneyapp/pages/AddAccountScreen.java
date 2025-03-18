package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindByChainSet;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.moneyapp.enums.InitialBalanceSources;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class AddAccountScreen extends BaseScreen{

    @AndroidFindBy(id = "editTextCategoryName")
    private WebElement accountNameInputField;

    @AndroidFindBy(id = "initialAmount")
    private WebElement initialAmountInputField;

    @AndroidFindBy(id = "save")
    private WebElement saveAccountButton;

    @AndroidFindByChainSet(
            @AndroidFindBys({
                    @AndroidBy(id = "gridViewCategoryImages"),
                    @AndroidBy(className = "android.widget.FrameLayout")
            })
    )
    private List<WebElement> sourcesOfBalanceList;

    public AddAccountScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void load() {
        super.load();
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        wait.until(visibilityOfAllElements(accountNameInputField, initialAmountInputField, saveAccountButton));
    }

    public AddAccountScreen enterAccountName(String accountName) {
        accountNameInputField.sendKeys(accountName);
        return this;
    }

    public AddAccountScreen enterInitialBalance(String initialBalance) {
        initialAmountInputField.sendKeys(initialBalance);
        return this;
    }

    public AddAccountScreen selectInitialBalanceSource(InitialBalanceSources source) {
        sourcesOfBalanceList.get(source.getIndex()).click();
        return this;
    }

    public AddAccountScreen confirmAddingAccount() {
        saveAccountButton.click();
        return this;
    }

}
