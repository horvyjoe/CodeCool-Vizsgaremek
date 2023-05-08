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
    @Tag("CHURL01")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Registration an Login page' - URL check")
    void navigateToRegistrationAndLoginPageTest() {
        getRegistrationAndLoginPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Registration and login page'");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Registration an Login page').");
    }

    @Test
    @Tag("CHURL02")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Terms and conditions' - URL check")
    void navigateToTermsAndConditionsPageTest() {
        getTermsAndConditionsPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Terms and conditions'");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Terms and conditions').");
    }

    @Test
    @Tag("CHURL03")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/about/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'About page' - URL check")
    void navigateToAboutPageTest() {
        getAboutPage().navigateTo();
        shootScreenshot("Page status after navigating to 'About page'");
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'About page').");
    }

    @Test
    @Tag("CHURL04")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/blog/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Blog page' - URL check")
    void navigateToBlogPageTest() {
        getBlogPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Blog page'");
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Blog page').");
    }
    @Test
    @Tag("CHURL05")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/contact/ URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Get in touch page' - URL check")
    void navigateToGetInTouchPageTest() {
        getGetInTouchPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Get in touch page'");
        Assertions.assertEquals(PagesUrl.GET_IN_TOUCH.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Get in touch page').");
    }

    @Test
    @Tag("CHURL06")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/landing.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Landing page' - URL check")
    void navigateToLandingPageTest() {
        getLandingPage().navigateTo();
        shootScreenshot("Page status after navigating to 'Landing page'");
        Assertions.assertEquals(PagesUrl.LANDING_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Landing page').");
    }

    @Test
    @Tag("CHURL07")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/profile URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Profile page' - URL check")
    void navigateToProfilePageTest() {
        getProfilePage().navigateTo();
        shootScreenshot("Page status after navigating to 'Profile page'");
        Assertions.assertEquals(PagesUrl.PROFILE_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL: " + driver.getCurrentUrl() + " doesn't match the expected URL (Expected: 'Profile page').");
    }
}
