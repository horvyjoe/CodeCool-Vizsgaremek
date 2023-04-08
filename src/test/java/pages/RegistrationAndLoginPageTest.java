package pages;

import enums.PagesUrl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationAndLoginPageTest {
    private WebDriver driver;

    private RegistrationAndLoginPage registrationAndLoginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.navigateTo();
    }


    @Test
    void clickAcceptTermsAndConditionsButton() {
        WebElement termsAndConditionsPopup = registrationAndLoginPage.findElementOnPage(By.className("popup"));

        Assertions.assertTrue(termsAndConditionsPopup.isDisplayed());
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        Assertions.assertFalse(termsAndConditionsPopup.isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void name() {
    }
}