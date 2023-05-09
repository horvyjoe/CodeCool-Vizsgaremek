package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;

@Epic("'Checking URL' functions - These tests covers the verification of the correct URL is loaded after navigation to the requested page.")
public class CheckUrlTest extends TestUtilities {
    @Test
    @Tag("URL01")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL01 - 'Registration and Login page' - URL check")
    void navigateToRegistrationAndLoginPageTest() {
        getRegistrationAndLoginPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Registration and login page'");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Registration an Login page').");
    }

    @Test
    @Tag("URL02")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/about/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL02 - 'About page' - URL check")
    void navigateToAboutPageTest() {
        getAboutPage().navigateTo();
        shootScreenshot("Page status after navigating to 'About page'");
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'About page').");
    }

    @Test
    @Tag("URL03")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/blog/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL03 - 'Blog page' - URL check")
    void navigateToBlogPageTest() {
        getBlogPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Blog page'");
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Blog page').");
    }
    @Test
    @Tag("URL04")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/contact/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL04 - 'Get in touch page' - URL check")
    void navigateToGetInTouchPageTest() {
        getGetInTouchPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Get in touch page'");
        Assertions.assertEquals(PagesUrl.GET_IN_TOUCH.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Get in touch page').");
    }

    @Test
    @Tag("URL05")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/landing.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL05 - 'Landing page' - URL check")
    void navigateToLandingPageTest() {
        getLandingPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Landing page'");
        Assertions.assertEquals(PagesUrl.LANDING_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Landing page').");
    }

    @Test
    @Tag("URL06")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/profile URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("URL06 - 'Profile page' - URL check")
    void navigateToProfilePageTest() {
        getProfilePage().navigateTo();
        shootScreenshot("Page status after navigating to 'Profile page'");
        Assertions.assertEquals(PagesUrl.PROFILE_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Profile page').");
    }
}
