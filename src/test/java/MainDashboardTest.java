import org.junit.jupiter.api.Test;
import org.moneyapp.pages.MainDashboardScreen;
import org.moneyapp.pages.SpecifyAmountScreen;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.moneyapp.ScreenManager.on;
import static org.moneyapp.enums.ExpenseCategories.CAR;
import static org.moneyapp.enums.IncomeSources.DEPOSITS;


public class MainDashboardTest extends BaseTest {

    @Test
    public void given_customer_when_addingCarExpense_then_totalExpensesBalanceIsUpdated()  {
        String expenseAmount = "20";

        MainDashboardScreen finalScreen = on(MainDashboardScreen.class, false)
                .addExpense()
                .on(SpecifyAmountScreen.class, false)
                .enterAmount(expenseAmount)
                .chooseCategory()
                .selectExpenseCategory(CAR)
                .on(MainDashboardScreen.class, true);

        assertThat(finalScreen.getTotalExpensesBalance()).contains(expenseAmount);
    }

    @Test
    public void given_customer_when_addingDepositsAsIncomeSource_then_totalIncomeBalanceIsUpdated()  {
        String incomeAmount = "50";

        MainDashboardScreen finalScreen = on(MainDashboardScreen.class, false)
                .addIncome()
                .on(SpecifyAmountScreen.class, false)
                .enterAmount(incomeAmount)
                .chooseCategory()
                .selectIncomeSource(DEPOSITS)
                .on(MainDashboardScreen.class, true);

        assertThat(finalScreen.getTotalIncomeBalance()).contains(incomeAmount);
    }

}


