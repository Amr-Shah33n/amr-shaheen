package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SideMenuScreen extends BaseScreen {

    @AndroidFindBy(id = "right_drawer")
    private WebElement menuContainer;

    @AndroidFindBy(id = "accounts_panel")
    private WebElement openAccountsButton;

    @AndroidFindBy(id = "imageButtonAddCategory")
    private WebElement addNewAccountButton;

    public SideMenuScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void isLoaded() throws Error {
        wait.until(visibilityOf(menuContainer));
        super.isLoaded();
    }

    public SideMenuScreen openAccountsPanel(){
        openAccountsButton.click();
        return this;
    }

    public SideMenuScreen addNewAccount(){
        wait.until(visibilityOf(addNewAccountButton)).click();
        return this;
    }

}
