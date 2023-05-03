package pages;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AboutPageTest {

    public WebDriver driver;
    private AboutPage aboutPage;
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

        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        landingPage = new LandingPage(driver);
        termsAndConditions = new TermsAndConditions(driver);
        registrationAndLoginPage.navigateTo();
        termsAndConditions.clickAcceptTermsAndConditionsButton();
        registrationAndLoginPage.performBuiltInLogin();
        aboutPage = new AboutPage(driver);


    }

    @Test
    @DisplayName("List expertises")
    void listExpertises() {
        aboutPage.navigateTo();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"Customer Experience Design", "Digital Products", "Development", "Campaign & Content",
                "Employer Branding", "Animation & Motion Graphics", "Packaging & Product Design",
                "Retail & Spacial", "Print & Editorial Design", "Concept/Text", "Information Design"};

        shootScreenshot("List expertises");
        Assertions.assertArrayEquals(expected, aboutPage.listExpertises());
    }

    // Shoot screenshot
    protected void shootScreenshot(String title){
        Allure.addAttachment(title, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
