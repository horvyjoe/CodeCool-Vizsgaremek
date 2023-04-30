package pages;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.GetInTouchPage;
import com.codecool.vizsgaremek.pages.LandingPage;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class GetInTouchPageTest {

    public WebDriver driver;
    private GetInTouchPage getInTouchPage;
    private LandingPage landingPage;
    private RegistrationAndLoginPage registrationAndLoginPage;
    private TermsAndConditions termsAndConditions;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        getInTouchPage = new GetInTouchPage(driver);
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        landingPage = new LandingPage(driver);
        termsAndConditions = new TermsAndConditions(driver);

        registrationAndLoginPage.navigateTo();
        termsAndConditions.clickAcceptTermsAndConditionsButton();
        registrationAndLoginPage.performBuiltInLogin();
        getInTouchPage.navigateTo();
    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sending message")
    void sendMessage() throws InterruptedException {
        landingPage.clickGetInTouchButton();
        getInTouchPage.performSendMessage(
                "András",
                "Lovasi",
                "bandiAHegyrol@kispal.hu",
                "Web Design",
                "Éjfél van a presszóban let's go van\n" +
                        "Mondja a kopasz erôs\n" +
                        "Aki az est gyôztese lesz - Jó - mondok\n" +
                        "- Csak én még egy kis maradékot meginnék\n" +
                        "- Látod itt elôttem ezt");
        String actualAlertText = getInTouchPage.GetAlertText();
        getInTouchPage.AcceptAlert();
        String expectedAlertText = "Message sent!";
        Assertions.assertEquals(expectedAlertText, actualAlertText);
        Thread.sleep(5000);
        Assertions.assertFalse(getInTouchPage.verifyMessageSent());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
