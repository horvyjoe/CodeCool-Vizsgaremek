package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Data modification' functions - These tests covers the verification of 'data modification' functions.")
public class DataModificationTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Tag("MOD01")
    @Description("Edit profile - Verifies changing data in profile is successful.")
    @Story("Edit profile - User changes personal information.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("MOD01 - Edit profile")
    void editProfileTest() {
        //Test data
        String username = "Bandi";
        String password = "dsgr34dsDFS";
        String email = "bandiahegyrol@ksipal.hu";
        String description = "Nagy a rendetlenség, ne nagyon nézzél szét!";
        String name = "Lovasi Bandi";
        String bio = "Bandi from the mountain";
        String phoneNumber = "+36906616969";

        //Test steps
        getRegistrationAndLoginPage().clickRegisterTab();
        getRegistrationAndLoginPage().typeRegistrationCredentials(username, password,email,description);
        getRegistrationAndLoginPage().clickRegisterButton();
        getRegistrationAndLoginPage().clickLoginTab();
        getRegistrationAndLoginPage().typeLoginCredentials(username,password);
        getRegistrationAndLoginPage().clickLoginButton();
        getLandingPage().clickProfileButton();
        getProfilePage().InputChangeProfileData(name, bio, phoneNumber);
        getProfilePage().clickSaveProfile();

        Assertions.assertTrue(getProfilePage().verifyProfileChanged(),"Failed to modify profile");
    }
}
