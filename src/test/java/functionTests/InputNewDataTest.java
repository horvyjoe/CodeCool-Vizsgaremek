package functionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Input new data' functions - These tests covers the verification of inputting new data functions.")
class InputNewDataTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().typeBuiltInLoginCredentials();
        getRegistrationAndLoginPage().clickLoginButton();
        getGetInTouchPage().navigateTo();
    }

    @Test
    @Tag("INP01")
    @Description("The test verifies the 'Get in touch' menu's send message function.")
    @Story("On Get in touch page sending a message must be possible.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("INP01 - Sending message")
    void sendMessage() throws InterruptedException {
        getLandingPage().clickGetInTouchButton();
        getGetInTouchPage().typeSendMessageCredentials(
                "András",
                "Lovasi",
                "bandiAHegyrol@kispal.hu",
                "Web Design",
                "Éjfél van a presszóban let's go van\n" +
                        "Mondja a kopasz erôs\n" +
                        "Aki az est gyôztese lesz - Jó - mondok\n" +
                        "- Csak én még egy kis maradékot meginnék\n" +
                        "- Látod itt elôttem ezt");
        getGetInTouchPage().clickSendMessageButton();
        String actualAlertText = getGetInTouchPage().getAlertText();
        getGetInTouchPage().acceptAlert();
        String expectedAlertText = "Message sent!";
        Assertions.assertEquals(expectedAlertText, actualAlertText,"Alert text doesn't confirm that message is successfully sent.");
        Thread.sleep(2000);

        Assertions.assertFalse(getGetInTouchPage().verifyMessageSentError(),"'Message not sent' error is visible on the screen");
    }
}
