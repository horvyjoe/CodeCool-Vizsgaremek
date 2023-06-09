package functionTests;

import com.codecool.vizsgaremek.pages.LandingPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Delete profile' functions - These tests covers the verification of 'deleting user profile' functions.")
public class DeleteProfileTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Feature("Delete profile")
    @Tag("DEL01")
    @Description("Delete profile - Validates deleting profile is successful.")
    @Story("Delete profile - User deletes user's account.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("DEL01 - Delete profile")
    void deleteProfileTest() {
        getRegistrationAndLoginPage().clickRegisterTab();

        // Test data
        String username = "Delete Me";
        String password = "uDeleteItItsNotImportant";
        String email = "stopDeletingMe@disappear.com";
        String description = "The end is coming!";

        //Test steps
        getRegistrationAndLoginPage().typeRegistrationCredentials(username, password, email, description);
        getRegistrationAndLoginPage().clickRegisterButton();
        getRegistrationAndLoginPage().clickLoginTab();
        getRegistrationAndLoginPage().typeLoginCredentials(username, password);
        getRegistrationAndLoginPage().clickLoginButton();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        getProfilePage().clickDeleteAccount();
        getProfilePage().clickConfirmDeleteAccount();
        getRegistrationAndLoginPage().typeLoginCredentials(username, description);
        getRegistrationAndLoginPage().clickLoginButton();

        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginFailed(),"Error: After deleting user profile, the user is still able to log in with the deleted profile's login credentials.");
    }
}
