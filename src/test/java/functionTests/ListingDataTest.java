package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testUtilities.TestUtilities;

import java.io.ByteArrayInputStream;

@Epic("'Listing data' functions - These tests covers the verification of data listing functions.")
@Feature("Listing data' functions")
public class ListingDataTest extends TestUtilities {
    @BeforeEach
    void setUpAboutPage() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }

    @Test
    @DisplayName("List expertises")
    void listExpertises() {
        getAboutPage().navigateTo();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"Failed to navigate to the correct page.");

        String[] expected = {"Customer Experience Design", "Digital Products", "Development", "Campaign & Content",
                "Employer Branding", "Animation & Motion Graphics", "Packaging & Product Design",
                "Retail & Spacial", "Print & Editorial Design", "Concept/Text", "Information Design"};

        shootScreenshot("List expertises");
        Assertions.assertArrayEquals(expected, getAboutPage().listExpertises(),"The actual expertises don't match with the expected");
    }
}
