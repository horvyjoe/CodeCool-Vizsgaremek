package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import testUtilities.TestUtilities;

public class LogoutTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getLandingPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }
    @Test
    @Feature("'Logout' function")
    @Tag("LOUT001")
    @Description("Logout - validating user logout is successful")
    @Story("Logout - User clicks on 'Logout' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Logout")
    void logoutTest () {
        getLandingPage().clickLogoutButton();
        shootScreenshot("Page status");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginWindow());
    }

    @Test
    @Feature("'Logout' function")
    @Tag("LOUT002")
    @Description("Logout and press 'back arrow' button - validating user logout is successful")
    @Story("Logout - User clicks on 'Logout' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Logout and press 'back'")
    void logoutAndPressBackTest() {
        getLandingPage().clickLogoutButton();
        //driver.navigate().back();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");

        Assertions.assertFalse(getLandingPage().verifyLogoutButtonIsDisplayed());
        shootScreenshot("Page status");
    }



}
