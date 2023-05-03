package pages;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("'Terms and conditions' functions - These tests covers the validation of 'Terms and conditions' functions features accessible directly from https://lennertamas.github.io/roxo/index.html url. Also verifies the url is correct.")

public class TermsAndConditionsTest {

    private WebDriver driver;
    private TermsAndConditions termsAndConditions;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.navigateTo();
    }

    @Test
    @Feature("Check URL")
    @Tag("TC001")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Navigate to URL")
    void navigateToUrlTest() {
        termsAndConditions.navigateTo();
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Feature("'Terms and conditions' functions")
    @Tag("TC002")
    @Description("Accept 'Terms and conditions'")
    @Story("Accept - Terms and conditions window is displayed and can be accepted by user.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Accept 'Terms and conditions'")
    void clickAcceptTermsAndConditionsButtonTest() {
        Assertions.assertTrue(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
        termsAndConditions.clickAcceptTermsAndConditionsButton();
        Assertions.assertFalse(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
    }

    @Test
    @Feature("'Terms and conditions' functions")
    @Tag("TC003")
    @Description("Close 'Terms and conditions'")
    @Story("Close - Terms and conditions window is displayed and can be closed by user with button 'X'.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Close 'Terms and conditions'")
    void clickCloseTermsAndConditionsButtonTest() {
        Assertions.assertTrue(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
        termsAndConditions.clickCloseTermsAndConditionsButton();
        Assertions.assertFalse(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
    }

    @Test
    @Feature("'Terms and conditions' functions")
    @Tag("TC004")
    @Description("Click out of 'Terms and conditions' window")
    @Story("Click out - Terms and conditions window is displayed and user clicks out of the window. The window must remain visible.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click out of 'Terms and conditions'")
    void clickOutsideTermsAndConditionsWindowTest() {
        Assertions.assertTrue(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
        termsAndConditions.clickOutsideTermsAndConditions();
        Assertions.assertTrue(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
    }

    @Test
    @Feature("'Terms and conditions' functions")
    @Tag("TC005")
    @Description("Comparing the text of 'Terms and conditions' to a text stored in a '.txt' file")
    @Story("Verify text - Terms and conditions window's displayed text must match text stored in 'termsAndConditions.txt'.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify text of 'Terms and conditions'")
    void verifyTermsAndConditionsTextTest() throws IOException {
        Assertions.assertTrue(termsAndConditions.validateTermsAndConditionsPopupIsDisplayed());
        String actual = termsAndConditions.getTextTermsAndConditions().replaceAll("\\r\\n", "\n");
        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/testData/termsAndConditions.txt"))).replaceAll("\\r\\n", "\n");
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
