package parabank.parasoft.com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.parasoft.com.pages.AccountOpenedPage;
import parabank.parasoft.com.pages.CustomerLoginPage;
import parabank.parasoft.com.pages.OpenNewAccountPage;
import parabank.parasoft.com.pages.OverviewPage;

public class OpenNewAccountTest extends BaseTest {


    @Test
    public void openAccountShouldSucceed() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
//        OverviewPage overviewPage = loginPage
//                .fillUsername(getUsername())
//                .fillPassword(getPassword())
//                .clickLoginBtn();

        OverviewPage overviewPage = loginPage
                .doLogin(getUsername(), getPassword());

        OpenNewAccountPage openNewAccountPage = overviewPage
                .clickOpenNewAccountLink()
                .selectType(1)
                .selectAccount(0);

        AccountOpenedPage accountOpenedPage = openNewAccountPage
                .clickNewAccountBtn();
        Assert.assertTrue(accountOpenedPage.isNewAccountId());

    }

    @Test(enabled = false)
    public void openAccountShouldSucceed2() {
        AccountOpenedPage openedPage = page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(), getPassword())
                .clickOpenNewAccountLink()
                .selectType(1)
                .selectAccount(0)
                .clickNewAccountBtn();

        Assert.assertTrue(openedPage.isNewAccountId());

    }

}
