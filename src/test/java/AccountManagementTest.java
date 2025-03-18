
import org.junit.jupiter.api.Test;
import org.moneyapp.pages.AddAccountScreen;
import org.moneyapp.pages.MainDashboardScreen;
import org.moneyapp.pages.SideFilterMenuScreen;
import org.moneyapp.pages.SideMenuScreen;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.moneyapp.ScreenManager.on;
import static org.moneyapp.enums.InitialBalanceSources.AMEX;

public class AccountManagementTest extends BaseTest {

    @Test
    public void given_customer_when_addingNewAccountWithBalance_then_accountHasBeenAddedSuccessfully() {
        String addedAccountName = on(MainDashboardScreen.class, false)
                .openSideMenu()
                .on(SideMenuScreen.class, true)
                .openAccountsPanel()
                .addNewAccount()
                .on(AddAccountScreen.class, true)
                .enterAccountName("Test Account")
                .enterInitialBalance("10")
                .selectInitialBalanceSource(AMEX)
                .confirmAddingAccount()
                .on(MainDashboardScreen.class, true)
                .openFilteringPanel()
                .on(SideFilterMenuScreen.class, true)
                .expandAccountsList()
                .getLatestAccountAddedName();

        assertThat(addedAccountName)
                .describedAs("Newly added account is visible")
                .isEqualTo("Test Account");
    }

}


