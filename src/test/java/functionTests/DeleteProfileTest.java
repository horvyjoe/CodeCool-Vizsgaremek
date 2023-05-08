package functionTests;

import com.codecool.vizsgaremek.pages.LandingPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Delete profile' functions - These tests covers the verification of 'deleting user profile' functions.")
@Feature("'Terms and conditions' functions")
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
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Delete profile")
    void deleteProfileTest() {
        getRegistrationAndLoginPage().navigateTo();
        getRegistrationAndLoginPage().clickRegisterTab();

        // Test data
        String username = "Delete Me";
        String password = "uDeleteItItsNotImportant";
        String email = "stopDeletingMe@yudothis@disappear.com";
        String description = "The end is coming!";

        //Test steps
        getRegistrationAndLoginPage().performRegistration(username, password, email, description);
        getRegistrationAndLoginPage().clickLoginTab();
        getRegistrationAndLoginPage().performLogin(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        getProfilePage().clickDeleteAccount();
        getProfilePage().clickConfirmDeleteAccount();
        getRegistrationAndLoginPage().performLogin(username, description);

        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginFailed(),"Error: After deleting user profile, the user is still able to log in with the deleted profile's login credentials.");
    }
}
