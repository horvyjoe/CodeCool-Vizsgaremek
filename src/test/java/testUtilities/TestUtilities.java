package testUtilities;
import com.codecool.vizsgaremek.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;

import io.qameta.allure.Step;

public abstract class TestUtilities {

        protected WebDriver driver;
        private RegistrationAndLoginPage registrationAndLoginPage;
        private TermsAndConditions termsAndConditions;
        private LandingPage landingPage;
        private AboutPage aboutPage;
        private BlogPage blogPage;
        private GetInTouchPage getInTouchPage;
        private ProfilePage profilePage;

        @BeforeAll
        static void beforeAll() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setUp() {
            driver = WebDriverFactory.getWebDriver();

        }

        protected final RegistrationAndLoginPage getRegistrationAndLoginPage() {
            if (registrationAndLoginPage == null) {
                registrationAndLoginPage = new RegistrationAndLoginPage(driver);
            }
            return registrationAndLoginPage;
        }

        protected final TermsAndConditions getTermsAndConditionsPage() {
            if (termsAndConditions == null) {
                termsAndConditions = new TermsAndConditions(driver);
            }
            return termsAndConditions;
        }

        protected final LandingPage getLandingPage() {
            if (landingPage == null) {
                landingPage = new LandingPage(driver);
            }
            return landingPage;
        }

        protected final AboutPage getAboutPage() {
            if (aboutPage == null) {
                aboutPage = new AboutPage(driver);
            }
            return aboutPage;
        }

        protected final BlogPage getBlogPage() {
            if (blogPage == null) {
                blogPage = new BlogPage(driver);
            }
            return blogPage;
        }

        protected final GetInTouchPage getGetInTouchPage() {
            if (getInTouchPage == null) {
                getInTouchPage = new GetInTouchPage(driver);
            }
            return getInTouchPage;
        }

        protected final ProfilePage getProfilePage() {
            if (profilePage == null) {
                profilePage = new ProfilePage(driver);
            }
            return profilePage;
        }

        @AfterEach
        final void tearDown() {
            driver.quit();
        }

        protected void shootScreenshot(String title) {
            Allure.addAttachment(title, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }

        // Write text to file
        @Step("Write text to file")
        protected void writeTextToFile(String text, String fileName) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(text);
                writer.close();
            } catch (IOException e) {
                System.err.println("Text writing to file error: " + e.getMessage());
            }
        }
}





