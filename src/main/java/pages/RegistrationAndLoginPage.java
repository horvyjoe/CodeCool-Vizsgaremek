package pages;

import enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationAndLoginPage extends Page{

    // LOCATORS
    // - Terms and conditions
    private static final By BUTTON_ACCEPT_TERMS_AND_CONDITIONS = By.id("terms-and-conditions-button");

    public RegistrationAndLoginPage(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    public void clickAcceptTermsAndConditionsButton() {
        findElementOnPage(BUTTON_ACCEPT_TERMS_AND_CONDITIONS).click();
    }
}
