package pages;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class BlogPageTest {

    public WebDriver driver;
    private BlogPage blogPage;
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
        blogPage = new BlogPage(driver);
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        landingPage = new LandingPage(driver);
        termsAndConditions = new TermsAndConditions(driver);
        registrationAndLoginPage.navigateTo();
        termsAndConditions.clickAcceptTermsAndConditionsButton();
        registrationAndLoginPage.performBuiltInLogin();

    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sending message")
    void blogTitleCollectTest() {
        landingPage.clickBlogButton();
        String[] actual = blogPage.findBlogTitles();
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
