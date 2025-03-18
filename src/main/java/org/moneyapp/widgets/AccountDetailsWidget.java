package org.moneyapp.widgets;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

public class AccountDetailsWidget extends Widget {

    @AndroidFindBy(id = "title")
    private WebElement accountName;

    @AndroidFindBy(id = "sp_currency_name")
    private WebElement currencyNameHolder;

    protected AccountDetailsWidget(WebElement element) {
        super(element);
    }

    public String getAccountName(){
        return accountName.getText();
    }

    public String getAccountCurrency(){
        return currencyNameHolder.getText();
    }
}
