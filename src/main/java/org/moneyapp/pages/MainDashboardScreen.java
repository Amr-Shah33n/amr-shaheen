package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class MainDashboardScreen extends BaseScreen {

    @AndroidFindBy(id = "expense_amount_text")
    private WebElement totalExpensesBalance;

    @AndroidFindBy(id = "income_amount_text")
    private WebElement totalIncomeBalance;

    @AndroidFindBy(id = "balance_amount")
    private WebElement netTotalBalance;

    @AndroidFindBy(id = "expense_button")
    private WebElement expenseButton;

    @AndroidFindBy(id = "income_button")
    private WebElement incomeButton;

    @AndroidFindBy(id = "overflow")
    private WebElement openSideMenuButton;

    public String getTotalExpensesBalance() { return totalExpensesBalance.getText(); }
    public String getTotalIncomeBalance() { return totalIncomeBalance.getText(); }
    public String getTotalNetBalance() { return netTotalBalance.getText(); }


    public MainDashboardScreen(boolean isLoaded) {
        super(isLoaded);
    }

    @Override
    protected void load() {
        super.load();
        new PromotionScreen(true).skipPromotion();
    }

    @Override
    protected void isLoaded() throws Error {
        wait.until(visibilityOfAllElements(totalExpensesBalance, totalIncomeBalance, netTotalBalance));
        super.isLoaded();
    }

    public MainDashboardScreen addExpense(){
        expenseButton.click();
        return this;
    }
    public MainDashboardScreen addIncome(){
        incomeButton.click();
        return this;
    }

    public MainDashboardScreen openSideMenu(){
        openSideMenuButton.click();
        return this;
    }

    public MainDashboardScreen openFilteringPanel(){
        actionsManager.swipeRight();
        return this;
    }

}
