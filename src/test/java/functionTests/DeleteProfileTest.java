package functionTests;

import com.codecool.vizsgaremek.pages.LandingPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

public class DeleteProfileTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }


    @Test
    @Feature("Delete profile")
    @Tag("PROF002")
    @Description("Delete profile - Validates deleting profile is successful.")
    @Story("Delete profile - User deletes user's account.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Delete profile")
    void deleteProfileTest() {
        getRegistrationAndLoginPage().navigateTo();
        getRegistrationAndLoginPage().clickRegisterTab();
        String username = "Delete Me";
        String password = "uDeleteItItsNotImportant";
        String email = "stopDeletingMe@yudothis@disappear.com";
        String description = "The end is coming!";
        getRegistrationAndLoginPage().performRegistration(username, password, email, description);
        getRegistrationAndLoginPage().clickLoginTab();

        getRegistrationAndLoginPage().performLogin(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        getProfilePage().clickDeleteAccount();
        getProfilePage().clickConfirmDeleteAccount();

        getRegistrationAndLoginPage().performLogin(username, description);
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginFailed());

    }
}
