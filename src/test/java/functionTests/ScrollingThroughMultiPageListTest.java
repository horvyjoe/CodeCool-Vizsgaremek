package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;
@Epic("'Scrolling through multi pages' functions - These tests covers the verification of scrolling through multiple pages.")
@Feature("'Scrolling through multi pages' functions")

public class ScrollingThroughMultiPageListTest extends TestUtilities {

    @BeforeEach
    void setupPreconditions(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }

    @Test
    @Description("The test verifies the titles of all blog pages.")
    @Story("User is collecting the titles of every blog. The blogs can be found on multiple pages.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Multi page scroll' - Collect blog titles ")
    void blogTitleCollectTest() {
        getLandingPage().clickBlogButton();
        String[] actual = getBlogPage().findBlogTitles();
        String[] expected = {
                "Design Inspiration: The Best Projects From December",
                "The 10 Biggest Rebrands and Logo Designs of 2019",
                "Design Inspiration: The Best Projects From November",
                "Pt Chooses Classic Blue for Its Colour of the Year 2020",
                "The 10 Biggest Product Stories of 2019"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

}
