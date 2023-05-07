package pageTests;

import testUtilities.TestUtilities;
import testUtilities.WebDriverFactory;
import com.codecool.vizsgaremek.pages.GetInTouchPage;
import com.codecool.vizsgaremek.pages.LandingPage;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;

public class GetInTouchPageTest extends TestUtilities {
    @BeforeEach
    void setUpPreconditions() {

        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
        getGetInTouchPage().navigateTo();
    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sending message")
    void sendMessage() throws InterruptedException {
        getLandingPage().clickGetInTouchButton();
        getGetInTouchPage().performSendMessage(
                "András",
                "Lovasi",
                "bandiAHegyrol@kispal.hu",
                "Web Design",
                "Éjfél van a presszóban let's go van\n" +
                        "Mondja a kopasz erôs\n" +
                        "Aki az est gyôztese lesz - Jó - mondok\n" +
                        "- Csak én még egy kis maradékot meginnék\n" +
                        "- Látod itt elôttem ezt");
        String actualAlertText = getGetInTouchPage().GetAlertText();
        getGetInTouchPage().AcceptAlert();
        String expectedAlertText = "Message sent!";
        Assertions.assertEquals(expectedAlertText, actualAlertText);
        Thread.sleep(5000);
        Assertions.assertFalse(getGetInTouchPage().verifyMessageSentError());
    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
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
                    .as("Message sent by" + firstname +" "+ lastname )
                    .isEqualTo(expectedAlertText);
            String shootScreenshotName = "Message sent by: " + firstname + lastname;
            shootScreenshot(shootScreenshotName);
            driver.navigate().refresh();
        }
        softAssertions.assertAll();
    }
}
