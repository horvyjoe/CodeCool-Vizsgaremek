package functionTests;

import com.codecool.vizsgaremek.pages.LandingPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Data modification' functions - These tests covers the verification of 'data modification' functions.")
@Feature("Edit profile")
public class DataModificationTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Tag("PROF002")
    @Description("Edit profile - Validates changing data in profile is successful.")
    @Story("Edit profile - User changes personal information.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Edit profile")
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
        getRegistrationAndLoginPage().performRegistration(username, password,email,description);
        getRegistrationAndLoginPage().clickLoginTab();
        getRegistrationAndLoginPage().performLogin(username,password);
        getLandingPage().clickProfileButton();
        getProfilePage().changeProfile(name, bio, phoneNumber);

        Assertions.assertTrue(getProfilePage().verifyProfileChanged(),"Failed to modify profile");
    }
}
