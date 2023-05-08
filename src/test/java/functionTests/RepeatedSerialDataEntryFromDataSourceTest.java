package functionTests;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;

import java.io.FileReader;
import java.io.IOException;
@Epic("'Repeated serial data entry from data source' functions - These tests covers the verification of the possibility to perform multiple inputs from data stored in a file.")
@Feature("'Repeated serial data entry from data source' functions")
public class RepeatedSerialDataEntryFromDataSourceTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
        getGetInTouchPage().navigateTo();
    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible. User is using data stored in a file for repeated serial data entry")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Send multiple messages from file")
    void sendMultipleMessage() throws InterruptedException, IOException, ParseException {
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

            getGetInTouchPage().performSendMessage(firstname, lastname, email, projectType, aboutProject);
            getGetInTouchPage().AcceptAlert();
            String expectedAlertText = "Message sent!";
            Thread.sleep(1500);

            softAssertions.assertThat(getGetInTouchPage().verifyMessageSentText())
                    .as("Error occurred when message sent by: " + firstname +" "+ lastname )
                    .isEqualTo(expectedAlertText);
            String shootScreenshotName = "Message sent by: " + firstname +" "+ lastname;
            shootScreenshot(shootScreenshotName);
            driver.navigate().refresh();
        }
        softAssertions.assertAll();
    }
}
