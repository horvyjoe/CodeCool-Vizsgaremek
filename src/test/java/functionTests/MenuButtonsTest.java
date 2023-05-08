package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import testUtilities.TestUtilities;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("'Menu button' functions - These tests verifies the control buttons are functioning as expected on the website.")
public class MenuButtonsTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getLandingPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Home' button is visible, and clicking on it navigates to the correct page.")
    @Story("User on landing page, clicks 'Home' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Home button")
    void clickHomeButtonTest() {
        Assertions.assertTrue(getLandingPage().verifyHomeButtonIsDisplayed(),"Home button is not displayed on page!");

        getLandingPage().clickHomeButton();

        shootScreenshot("Page status after clicked 'Home' button");
        Assertions.assertFalse(getLandingPage().verifyHomeButtonNavigation(),"Navigation failed after clicking Home button");
    }

    @Test
    @Description("The test verifies that on LandingPage the 'About' button is visible, and clicking on it navigates to the correct page.")
    @Story("User on landing page clicks 'About' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click About button")
    void clickAboutButtonTest() {
        Assertions.assertTrue(getLandingPage().verifyAboutButtonIsDisplayed(),"About button is not displayed on page!");

        getLandingPage().clickAboutButton();

        shootScreenshot("Page status after clicked 'About' button");
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"Navigation failed after clicking About button");
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Get in touch' button is visible, and clicking on it navigates to the correct page.")
    @Story("User on landing page clicks 'Get in touch' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Get in touch button")
    void clickGetInTouchButtonTest() {
        Assertions.assertTrue(getLandingPage().verifyGetInTouchButtonIsDisplayed(),"'Get in touch' button is not displayed on page!");

        getLandingPage().clickGetInTouchButton();

        shootScreenshot("Page status after clicked 'Get in touch' button");
        Assertions.assertEquals(PagesUrl.GET_IN_TOUCH.getUrl(), driver.getCurrentUrl(),"Navigation failed after clicking 'Get in touch' button");
    }
}