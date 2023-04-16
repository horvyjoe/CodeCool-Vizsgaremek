package pages;

import enums.PagesUrl;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationAndLoginPage extends Page{

    public RegistrationAndLoginPage(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    // LOCATORS
    // - Terms and conditions
    private static final By BUTTON_ACCEPT_TERMS_AND_CONDITIONS = By.id("terms-and-conditions-button");
    private static final By BUTTON_REGISTER = By.id("register-form-button");
    private static final By POPUP_TERMS_AND_CONDITIONS = By.className("popup");

    // - Register new user
    private static final By FIELD_EMAIL_TO_REGISTER = By.id("register-email");

    // Terms and conditions function

    public void clickAcceptTermsAndConditionsButton() {
        findElementOnPage(BUTTON_ACCEPT_TERMS_AND_CONDITIONS).click();
    }

    public boolean validateTermsAndConditionsPopupIsDisplayed() {
        return findElementOnPage(POPUP_TERMS_AND_CONDITIONS).isDisplayed();
    }

    // Register new user function

    public void clickRegisterButton() {
        findElementOnPage(BUTTON_REGISTER).click();
    }

    public boolean validateRegisterWindow () {
        return findElementOnPage(FIELD_EMAIL_TO_REGISTER).isDisplayed();
    }

}
