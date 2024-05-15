package parabank.parasoft.com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import parabank.parasoft.com.pages.CustomerLoginPage;
import parabank.parasoft.com.pages.OverviewPage;
import parabank.parasoft.com.utill.ParaBankString;

public class CustomerLoginTest extends BaseTest {
    @Test
    public void checkLoginPage() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertTrue(loginPage.isLoginPage());
    }

    @Test
    public void checkLoginPageTittle() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITTLE);
    }


    @Test
    public void loginShouldSucceed() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);

        loginPage = loginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        OverviewPage overviewPage = loginPage
                .clickLoginBtn();
        Assert.assertTrue(overviewPage.isLogout());

    }

    @Test
    public void loginShouldSucceed2() {
        OverviewPage overviewPage = page.getInstance(CustomerLoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overviewPage.isLogout());

    }
}