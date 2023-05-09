package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Registration' functions - These tests covers the verifications of registration related features and page behaviours.")
public class RegistrationTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Tag("REG001")
    @Description("Register tab - validating switching tab when 'Register' tab is clicked")
    @Story("Register tab - By clicking on 'Register' tab, the tab switches to register tab.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Switch to 'Register' tab")
    void switchToRegisterTabTest () {
        getRegistrationAndLoginPage().clickRegisterTab();

        shootScreenshot("Page status after 'Register' tab is clicked");
        Assertions.assertTrue(getRegistrationAndLoginPage().validateRegisterWindow(),"Failed switch to 'Register' tab");
    }

    @Test
    @Tag("REG002")
    @Description("Using correct credentials - validating new user registration is possible")
    @Story("Correct credentials - User registers a new user with correct credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Correct credentials registration")
    void registerNewUserTest () {

        //Testdata
        String username = "John";
        String password = "Doe123";
        String email = "johndoe@gmail.com";
        String description = "John Doe is back";

        //Test steps
        getRegistrationAndLoginPage().clickRegisterTab();
        getRegistrationAndLoginPage().typeRegistrationCredentials(username, password, email, description);
        getRegistrationAndLoginPage().clickRegisterButton();


        //Shoot screenshot for Allure report
        shootScreenshot("Page status after registration with correct credentials");

        //Test result
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful(),"Registration failed with correct registration credentials");
    }

    @Test
    @Tag("REG003")
    @Description("Using 'empty' credentials - validating new user registration is not possible when no data's are provided")
    @Story("Empty credentials - User registers a new user with empty credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Empty credentials registration")
    void registerWithEmptyCredentialsTest () {
        getRegistrationAndLoginPage().clickRegisterTab();
        getRegistrationAndLoginPage().clickRegisterButton();

        shootScreenshot("Page status after empty credentials registration");
        Assertions.assertFalse(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful(),"Error! Successfully registered with 'EMPTY' credentials ");
    }

    @Test
    @Tag("REG004")
    @Description("Using 'invalid email' credentials - new user registration is not possible when no valid email address is provided")
    @Story("Invalid email credential - User registers a new user with invalid email credential.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Invalid email credential registration")
    void registerWithInvalidEmailTest () {
        //Test data
        String username = "johnDoe";
        String password = "Doe123";
        String email = "j@hnd@e@gmail+c@m";
        String description = "John Doe is back";

        //Test steps
        getRegistrationAndLoginPage().clickRegisterTab();
        getRegistrationAndLoginPage().typeRegistrationCredentials(username, password, email, description);
        getRegistrationAndLoginPage().clickRegisterButton();


        //Shoot screenshot for Allure report
        shootScreenshot("Page status after invalid email credential registration");

        //Test results
        Assertions.assertFalse(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful(),"Error: Successfully registered with the following 'INVALID' email address: "+email);
    }
}
