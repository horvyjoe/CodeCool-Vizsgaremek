package functionTests;

import com.codecool.vizsgaremek.pages.LandingPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

public class DataModificationTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Feature("Edit profile")
    @Tag("PROF002")
    @Description("Edit profile - Validates changing data in profile is successful.")
    @Story("Edit profile - User changes personal information.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Edit profile")
    void editProfileTest() {

        getRegistrationAndLoginPage().clickRegisterTab();
        getRegistrationAndLoginPage().performRegistration("Bandi", "dsgr34dsDFS", "bandiahegyrol@ksipal.hu", "Nagy a rendetlenség, ne nagyon nézzél szét!");
        getRegistrationAndLoginPage().clickLoginTab();

        getRegistrationAndLoginPage().performLogin("Bandi", "dsgr34dsDFS");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();


        String name = "Lovasi Bandi";
        String bio = "Bandi from the mountain";
        String phoneNumber = "+36906616969";
        getProfilePage().changeProfile(name, bio, phoneNumber);
        Assertions.assertTrue(getProfilePage().verifyProfileChanged());
    }


}
