package pages;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.LandingPage;
import com.codecool.vizsgaremek.pages.ProfilePage;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
@Epic("'Profile page' functions - These tests covers the validation of features accessible directly from https://lennertamas.github.io/roxo/profile url. Such as change profile, delete profile functions. Also verifies the url is correct.")
public class ProfilePageTest {

        private WebDriver driver;
        private RegistrationAndLoginPage registrationAndLoginPage;
        private TermsAndConditions termsAndConditions;
        private ProfilePage profilePage;
        private LandingPage landingPage;

        @BeforeAll
        static void beforeAll() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setUp() {
            driver = WebDriverFactory.getWebDriver();
            profilePage = new ProfilePage(driver);
            profilePage.navigateTo();
            termsAndConditions = new TermsAndConditions(driver);
            termsAndConditions.clickAcceptTermsAndConditionsButton();


        }

        @Test
        @Feature("Check URL")
        @Tag("PROF001")
        @Description("Validates navigating to the given URL is successful.")
        @Story("URL check - User navigates to https://lennertamas.github.io/roxo/profile URL.")
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Navigate to URL")
        void navigateToUrlTest() {
            Assertions.assertEquals(PagesUrl.PROFILE_PAGE.getUrl(), driver.getCurrentUrl());
        }

        @Test
        @Feature("Edit profile")
        @Tag("PROF002")
        @Description("Edit profile - Validates changing data in profile is successful.")
        @Story("Edit profile - User changes personal information.")
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Edit profile")
        void editProfileTest() {
            registrationAndLoginPage = new RegistrationAndLoginPage(driver);
            registrationAndLoginPage.navigateTo();
            registrationAndLoginPage.clickRegisterTab();
            registrationAndLoginPage.performRegistration("Bandi", "dsgr34dsDFS", "bandiahegyrol@ksipal.hu", "Nagy a rendetlenség, ne nagyon nézzél szét!");
            registrationAndLoginPage.clickLoginTab();

            registrationAndLoginPage.performLogin("Bandi", "dsgr34dsDFS");
            LandingPage landingPage = new LandingPage(driver);
            landingPage.clickProfileButton();


            String name = "Lovasi Bandi";
            String bio = "Bandi from the mountain";
            String phoneNumber = "+36906616969";
            profilePage.changeProfile(name, bio, phoneNumber);
            Assertions.assertTrue(profilePage.verifyProfileChanged());
        }

    @Test
    @Feature("Delete profile")
    @Tag("PROF002")
    @Description("Delete profile - Validates deleting profile is successful.")
    @Story("Delete profile - User deletes user's account.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Delete profile")
    void deleteProfileTest() {
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.clickRegisterTab();
        String username = "Delete Me";
        String password = "uDeleteItItsNotImportant";
        String email = "stopDeletingMe@yudothis@disappear.com";
        String description = "The end is coming!";
        registrationAndLoginPage.performRegistration(username, password, email, description);
        registrationAndLoginPage.clickLoginTab();

        registrationAndLoginPage.performLogin(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickProfileButton();
        profilePage.clickDeleteAccount();
        profilePage.clickConfirmDeleteAccount();

        registrationAndLoginPage.performLogin(username, description);
        Assertions.assertTrue(registrationAndLoginPage.verifyLoginFailed());

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
