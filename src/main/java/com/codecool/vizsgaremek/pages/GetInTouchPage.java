package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GetInTouchPage extends Page{

    // -LOCATORS
    private static final By FIELD_FIRST_NAME = By.id("first-name");
    private static final By FIELD_LAST_NAME = By.id("last-name");
    private static final By FIELD_EMAIL = By.id("email");
    private static final By FIELD_ABOUT_PROJECT = By.id("aboutProject");
    private static final By DROPDOWN_PROJECT_TYPE = By.id("projectType");
    private static final By BUTTON_SEND_MESSAGE = By.id("contact-form-button");
    private static final By TEXT_THERE_WAS_A_PROBLEM = By.id("contact-form-status");


    public GetInTouchPage(WebDriver driver) {
        super(PagesUrl.GET_IN_TOUCH.getUrl(), driver);
    }

    @Step("Type required data to the correct field (First name, Last name, Email, Message, and select Project type from dropdown list)")
    public void TypeSendMessageCredentials(String firstname, String lastname, String email, String projectType, String message) {
        findElementOnPage(FIELD_FIRST_NAME).sendKeys(firstname);
        findElementOnPage(FIELD_LAST_NAME).sendKeys(lastname);
        findElementOnPage(FIELD_EMAIL).sendKeys(email);
        new Select(findElementOnPage(DROPDOWN_PROJECT_TYPE)).selectByVisibleText(projectType);
        findElementOnPage(FIELD_ABOUT_PROJECT).sendKeys(message);
    }

    @Step("Click 'Send message' button")
    public void clickSendMessageButton() {
    findElementOnPage(BUTTON_SEND_MESSAGE).click();}


    public boolean verifyMessageSentError() {
        return findElementOnPage(TEXT_THERE_WAS_A_PROBLEM).isDisplayed();
    }

    public String verifyMessageSentText() {
        return findElementOnPage(TEXT_THERE_WAS_A_PROBLEM).getText();
    }

}
