
import org.junit.jupiter.api.Test;
import org.moneyapp.pages.MainDashboardScreen;
import org.moneyapp.pages.SpecifyAmountScreen;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.moneyapp.ScreenManager.on;
import static org.moneyapp.enums.ExpenseCategories.CAR;


public class AccountManagementTest extends BaseTest{

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

}


