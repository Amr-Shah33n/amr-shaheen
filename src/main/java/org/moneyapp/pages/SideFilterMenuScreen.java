package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindByChainSet;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.moneyapp.widgets.AccountDetailsWidget;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SideFilterMenuScreen extends BaseScreen {

    @AndroidFindBy(id = "foreground")
    private WebElement expandAccountsListButton;

    @AndroidFindByChainSet(
            @AndroidFindBys({
                    @AndroidBy(id = "listView"),
                    @AndroidBy(className = "android.widget.LinearLayout"),
                    @AndroidBy(className = "android.widget.LinearLayout")
            })
    )
    private List<AccountDetailsWidget> listOfCurrentAccounts;

    public SideFilterMenuScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        wait.until(visibilityOf(expandAccountsListButton));
    }

    public SideFilterMenuScreen expandAccountsList(){
        expandAccountsListButton.click();
        return this;
    }

    public String getLatestAccountAddedName(){
        return listOfCurrentAccounts.get(listOfCurrentAccounts.size()-1).getAccountName();
    }

}
