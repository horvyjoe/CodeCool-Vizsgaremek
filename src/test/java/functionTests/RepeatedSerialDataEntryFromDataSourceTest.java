package functionTests;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;

import java.io.FileReader;
import java.io.IOException;
@Epic("'Repeated serial data entry from data source' functions - These tests covers the verification of the possibility to perform multiple inputs from data stored in a file.")
class RepeatedSerialDataEntryFromDataSourceTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Tag("REP01")
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible. User is using data stored in a file for repeated serial data entry")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("REP01 - Send multiple messages from file")
    void sendMultipleMessage() throws InterruptedException, IOException, ParseException {
        getRegistrationAndLoginPage().typeBuiltInLoginCredentials();
        getRegistrationAndLoginPage().clickLoginButton();
        getLandingPage().clickGetInTouchButton();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/testData/sendMessage.json"));
        JSONArray jsonArray = (JSONArray) obj;

        SoftAssertions softAssertions = new SoftAssertions();

        for (Object object : jsonArray) {
            JSONObject users = (JSONObject) object;
            String firstname = (String) users.get("firstname");
            String lastname = (String) users.get("lastname");
            String email = (String) users.get("email");
            String projectType = (String) users.get("project type");
            String aboutProject = (String) users.get("about project");

            getGetInTouchPage().typeSendMessageCredentials(firstname, lastname, email, projectType, aboutProject);
            getGetInTouchPage().clickSendMessageButton();
            getGetInTouchPage().acceptAlert();
            String expectedAlertText = "Message sent!";
            Thread.sleep(500);

            softAssertions.assertThat(getGetInTouchPage().verifyMessageSentText())
                    .as("Error occurred when message sent by: " + firstname + " " + lastname )
                    .isEqualTo(expectedAlertText);
            String shootScreenshotName = "Message sent by: " + firstname +" "+ lastname;
            shootScreenshot("Page status after ' " + firstname + " " + lastname + " ' user's attempt to send message");
            driver.navigate().refresh();
        }
        softAssertions.assertAll();
    }

    @Test
    @Tag("REP02")
    @Description("Multiple valid users register - Reading valid registration credentials from a file, multiple users can be registered.")
    @Story("Multiple valid users register - User registers multiple accounts from valid credentials stored in a file.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("REP02 - Multiple valid users register")
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

            getRegistrationAndLoginPage().typeRegistrationCredentials(username, password, email, description);
            getRegistrationAndLoginPage().clickRegisterButton();

            softAssertions.assertThat(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful())
                    .as("Error: Registration failed with the following 'VALID' credentials:\nUsername: " + username +"\nPassword: " + password + "\nE-mail: " + email + "\nDescription: " + description)
                    .isEqualTo(true);
            shootScreenshot("Page status after ' " + username + " ' user's attempt to register");
            driver.navigate().refresh();
            getRegistrationAndLoginPage().clickRegisterTab();
        }
        softAssertions.assertAll();
    }

    @Test
    @Tag("REP03")
    @Description("Multiple invalid email users register - Reading invalid email registration credentials from a file, registrations must fail.")
    @Story("Multiple invalid users register - User registers multiple accounts from invalid email credentials stored in a file.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("REP03 - Multiple invalid users register")
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

            getRegistrationAndLoginPage().typeRegistrationCredentials(username, password, email, description);
            getRegistrationAndLoginPage().clickRegisterButton();

            softAssertions.assertThat(getRegistrationAndLoginPage().verifyRegistrationIsSuccessful()).
                    as("Error: registration successful with the following 'INVALID' email address: '" + email + "'").
                    isEqualTo(false);
            shootScreenshot("Page status after registration attempt with email address: " + email);
            driver.navigate().refresh();
            getRegistrationAndLoginPage().clickRegisterTab();
        }
        softAssertions.assertAll();
    }
}
