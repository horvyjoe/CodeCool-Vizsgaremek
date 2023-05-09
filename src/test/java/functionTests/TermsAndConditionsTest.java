package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("'Terms and conditions' functions - These tests covers the verification of 'Terms and conditions' functions.")
public class TermsAndConditionsTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getRegistrationAndLoginPage().navigateTo();
    }

    @Test
    @Tag("TC01")
    @Description("Accept 'Terms and conditions'")
    @Story("Accept - Terms and conditions window is displayed and can be accepted by user.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("TC01 - Accept 'Terms and conditions'")
    void clickAcceptTermsAndConditionsButtonTest() {
        Assertions.assertTrue(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"Terms and conditions popup is NOT displayed!");
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        shootScreenshot("Terms and conditions are accepted");
        Assertions.assertFalse(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"After accepted the terms and conditions, the 'Terms and conditions' popup is still displayed!");
    }

    @Test
    @Tag("TC02")
    @Description("Close 'Terms and conditions'")
    @Story("Close - Terms and conditions window is displayed and can be closed by user with button 'X'.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("TC02 - Close 'Terms and conditions'")
    void clickCloseTermsAndConditionsButtonTest() {
        Assertions.assertTrue(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"Terms and conditions popup is NOT displayed!");
        getTermsAndConditionsPage().clickCloseTermsAndConditionsButton();
        shootScreenshot("Terms and conditions popup is closed");
        Assertions.assertFalse(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"After closed the terms and conditions, the 'Terms and conditions' popup is still displayed!");
    }

    @Test
    @Tag("TC03")
    @Description("Click out of 'Terms and conditions' window")
    @Story("Click out - Terms and conditions window is displayed and user clicks out of the window. The window must remain visible.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC03 - Click out of 'Terms and conditions'")
    void clickOutsideTermsAndConditionsWindowTest() {
        Assertions.assertTrue(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"Terms and conditions popup is NOT displayed!");
        getTermsAndConditionsPage().clickOutsideTermsAndConditions();
        shootScreenshot("Clicked out of 'Terms and conditions' popup");
        Assertions.assertTrue(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"After clicked out of 'Terms and conditions popup', the popup is no longer displayed!");
    }

    @Test
    @Tag("TC04")
    @Description("Comparing the text of 'Terms and conditions' to a text stored in a '.txt' file")
    @Story("Verify text - Terms and conditions window's displayed text must match text stored in 'termsAndConditions.txt'.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC04 - Verify text of 'Terms and conditions'")
    void verifyTermsAndConditionsTextTest() throws IOException {
        shootScreenshot("Actual text of 'Terms and conditions' popup");
        Assertions.assertTrue(getTermsAndConditionsPage().validateTermsAndConditionsPopupIsDisplayed(),"Terms and conditions popup is NOT displayed!");
        String actual = getTermsAndConditionsPage().getTextTermsAndConditions().replaceAll("\\r\\n", "\n");
        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/testData/termsAndConditions.txt"))).replaceAll("\\r\\n", "\n");
        Assertions.assertEquals(expected, actual,"Terms and condititons text doesn't match the text stored in termsAndConditions.txt. They must be identical!");
    }
}
