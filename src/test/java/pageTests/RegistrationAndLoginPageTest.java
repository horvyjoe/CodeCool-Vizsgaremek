package pageTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

import java.io.*;


@Epic("'-Register' and '-Login' functions - These tests covers the verification of features accessible directly from https://lennertamas.github.io/roxo/index.html url. Also verifies the url is correct.")
public class RegistrationAndLoginPageTest extends TestUtilities{

    @BeforeEach
    void setupPage(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Feature("Check URL")
    @Tag("REG001")
    @Description("Verifies navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Navigate to URL")
    void navigateToUrlTest() {
        shootScreenshot("Page status after navigating to 'registration and login page'");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL doesn't match the expected URL.");
    }

    @Test
    @Feature("Serial data input from file")
    @Feature("'Registration' function")
    @Tag("REG006")
    @Description("Multiple valid users register - Reading valid registration credentials from a file, multiple users can be registered.")
    @Story("Multiple valid users register - User registers multiple accounts from valid credentials stored in a file.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Multiple valid users register")
    void registerMultipleValidUsersTest () throws IOException, ParseException {

        getRegistrationAndLoginPage().clickRegisterTab();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/testData/usersValid.json"));
        JSONArray jsonArray = (JSONArray) obj;
        SoftAssertions softAssertions = new SoftAssertions();
        for(Object object : jsonArray) {
            JSONObject users = (JSONObject) object;
            String username = (String) users.get("username");
            String password = (String) users.get("password");
            String email = (String) users.get("email");
            String description = (String) users.get("description");

            getRegistrationAndLoginPage().performRegistration(username, password, email, description);
            softAssertions.assertThat(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful())
                    .as("Error: Registration failed with the following 'VALID' credentials:\nUsername: " + username +"\nPassword: " + password + "\nE-mail: " + email + "\nDescription: " + description)
                    .isEqualTo(true);
            driver.navigate().refresh();
            getRegistrationAndLoginPage().clickRegisterTab();

            shootScreenshot("Page status after multiple valid users register registration");
        }
        softAssertions.assertAll();
     }

    @Test
    @Feature("Serial data input from file")
    @Feature("'Registration' function")
    @Tag("REG007")
    @Description("Multiple invalid email users register - Reading invalid email registration credentials from a file, registrations must fail.")
    @Story("Multiple invalid users register - User registers multiple accounts from invalid email credentials stored in a file.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Multiple invalid users register")
    void registerMultipleInvalidEmailUsersTest () throws IOException, ParseException {

        getRegistrationAndLoginPage().clickRegisterTab();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/testData/usersInvalidEmail.json"));
        JSONArray jsonArray = (JSONArray) obj;
        SoftAssertions softAssertions = new SoftAssertions();
        for(Object object : jsonArray) {
            JSONObject users = (JSONObject) object;
            String username = (String) users.get("username");
            String password = (String) users.get("password");
            String email = (String) users.get("email");
            String description = (String) users.get("description");

            getRegistrationAndLoginPage().performRegistration(username, password, email, description);
            softAssertions.assertThat(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful()).
                    as("Error: registration successful with the following 'INVALID' email address: '" + email+"'").
                    isEqualTo(false);
            driver.navigate().refresh();
            getRegistrationAndLoginPage().clickRegisterTab();

            shootScreenshot("Page status after registration with multiple invalid email addresses");
        }
        softAssertions.assertAll();
    }
}