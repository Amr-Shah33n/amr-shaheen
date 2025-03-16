package org.moneyapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        super.isLoaded();
        assertThat(wait.until(visibilityOfAllElements(Arrays.asList(expenseButton, incomeButton))))
                .describedAs("Asserting page has been loaded")
                .isNotNull();
    }

    public MainDashboardScreen addExpense(){
        expenseButton.click();
        return this;
    }
    public MainDashboardScreen addIncome(){
        incomeButton.click();
        return this;
    }


}
