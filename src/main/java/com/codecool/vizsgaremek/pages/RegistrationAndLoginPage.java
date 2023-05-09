package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationAndLoginPage extends Page{

    public RegistrationAndLoginPage(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    // LOCATORS
    // - Register new user
    private static final By FIELD_USERNAME_TO_REGISTER = By.id("register-username");
    private static final By FIELD_PASSWORD_TO_REGISTER = By.id("register-password");
    private static final By FIELD_EMAIL_TO_REGISTER = By.id("register-email");
    private static final By FIELD_DESCRIPTION_TO_REGISTER = By.id("register-description");
    private static final By BUTTON_TAB_REGISTER = By.id("register-form-button");
    private static final By BUTTON_REGISTER = By.xpath("//*[@id=\'register\']//*[@class=\'formGroup\']//*[@class=\'btn2\']");
    private static final By TEXT_USER_REGISTERED = By.id("register-alert");

    // - Login
    private static final String BUILT_IN_USERNAME = "lovasia";
    private static final String BUILT_IN_PASSWORD = "kispal123";
    private static final By BUTTON_TAB_LOGIN = By.xpath("//*[@id='register']//*[@id='login-form-button']");
    private static final By FIELD_USERNAME = By.id("email");
    private static final By FIELD_PASSWORD = By.id("password");
    private static final By BUTTON_LOGIN = By.xpath("//*[@onclick='myFunction()']");
    private static final By TEXT_USERNAME_OR_PASSWORD_IS_NOT_CORRECT = By.id("alert");

    // - Profile
    private static final By BUTTON_PROFILE = By.id("profile-btn");

    // FUNCTIONS

    @Step("Click 'Register' tab")
    public void clickRegisterTab() {
        findElementOnPage(BUTTON_TAB_REGISTER).click();
    }

    public boolean validateRegisterWindow () {
        return findElementOnPage(FIELD_EMAIL_TO_REGISTER).isDisplayed();
    }

    @Step("Type in registration credentials given in test data (username, password, email, description)")
    public void typeRegistrationCredentials(String username, String password, String email, String description) {
        findElementOnPage(FIELD_USERNAME_TO_REGISTER).sendKeys(username);
        findElementOnPage(FIELD_PASSWORD_TO_REGISTER).sendKeys(password);
        findElementOnPage(FIELD_EMAIL_TO_REGISTER).sendKeys(email);
        findElementOnPage(FIELD_DESCRIPTION_TO_REGISTER).sendKeys(description);
    }

    public boolean verifyRegistrationIsSuccessful(){
       return findElementOnPage(TEXT_USER_REGISTERED).isDisplayed();
    }

    @Step("Click 'Register' button")
    public void clickRegisterButton() {
        findElementOnPage(BUTTON_REGISTER).click();
    }

    public boolean verifyLoginWindow() {
        return findElementOnPage(BUTTON_LOGIN).isDisplayed();
    }

    @Step("Click 'Login' tab")
    public void clickLoginTab() {
        findElementOnPage(BUTTON_TAB_LOGIN).click();
    }

    @Step("Click 'Login' button")
    public void clickLoginButton() {
        findElementOnPage(BUTTON_LOGIN).click();
    }

    @Step("Type in login credentials given in test data (username and password)")
    public void typeLoginCredentials(String username, String password) {
        findElementOnPage(FIELD_USERNAME).sendKeys(username);
        findElementOnPage(FIELD_PASSWORD).sendKeys(password);
    }

    public boolean verifyLoginFailed() {
        return findElementOnPage(TEXT_USERNAME_OR_PASSWORD_IS_NOT_CORRECT).isDisplayed();
    }
    public boolean verifyLoginSuccessful() {
        return findElementOnPage(BUTTON_PROFILE).isDisplayed();
    }

    @Step("Type built in login credentials to login fields. Built in username: "+BUILT_IN_USERNAME+", Built in password: "+BUILT_IN_PASSWORD)
    public void typeBuiltInLoginCredentials(){
        findElementOnPage(FIELD_USERNAME).sendKeys(BUILT_IN_USERNAME);
        findElementOnPage(FIELD_PASSWORD).sendKeys(BUILT_IN_PASSWORD);
    }
}
