package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testUtilities.TestUtilities;

@Epic("'Listing data' functions - These tests covers the verification of data listing functions.")
public class ListingDataTest extends TestUtilities {
    @BeforeEach
    void setUpPreconditionSteps() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }

    @Test
    @Description("The test verifies the list of 'expertises' on About page.")
    @Story("On 'About' page, user collects all the listed expertises.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("List expertises")
    void listExpertises() {
        getAboutPage().navigateTo();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"Failed to navigate to the correct page.");

        String[] expected = {"Customer Experience Design", "Digital Products", "Development", "Campaign & Content",
                "Employer Branding", "Animation & Motion Graphics", "Packaging & Product Design",
                "Retail & Spacial", "Print & Editorial Design", "Concept/Text", "Information Design"};

        Assertions.assertArrayEquals(expected, getAboutPage().listExpertises(),"The actual expertises list don't match the expected");
    }

    @Test
    @Description("The test verifies the list of 'team members' on About page.")
    @Story("On 'About' page, user collects all the listed team members.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("List team members")
    void listTeamMembers() {
        getAboutPage().navigateTo();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl(),"Failed to navigate to the correct page.");

        String[] expected = {"PABLO ESCOBAR", "MONTINO RIAU", "ALEX NAASRI", "HONGMAN CHIOA",
                "SANTIO ANDRESS", "RAMESH PAUL"};

        Assertions.assertArrayEquals(expected, getAboutPage().listTeamMembers(),"The actual team members list don't match the expected");
    }
}
