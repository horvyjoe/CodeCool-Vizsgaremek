package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;

@Epic("'Input new data' functions - These tests covers the verification of inputting new data functions.")
public class InputNewDataTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {

        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
        getGetInTouchPage().navigateTo();
    }

    @Test
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
    @Severity(SeverityLevel.MINOR)
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
        Assertions.assertEquals(expectedAlertText, actualAlertText,"Alert text doesn't confirm that message is successfully sent.");
        Thread.sleep(5000);

        Assertions.assertFalse(getGetInTouchPage().verifyMessageSentError(),"'Message not sent' error is visible on the screen");
    }
}
