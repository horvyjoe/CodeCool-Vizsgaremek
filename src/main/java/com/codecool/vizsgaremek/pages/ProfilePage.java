package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page{
    public ProfilePage(WebDriver driver) {
        super(PagesUrl.PROFILE_PAGE.getUrl(), driver);
    }

    //LOCATORS

    private static final By FIELD_NAME = By.id("name");
    private static final By FIELD_BIO = By.id("bio");
    private static final By FIELD_PHONE_NUMBER = By.id("phone-number");
    private static final By BUTTON_SAVE_PROFILE = By.xpath("//*[@onclick='editUser()']");
    private static final By BUTTON_DELETE_ACCOUNT = By.xpath("//*[@onclick='showRealDeleteAccBtn()']");
    private static final By BUTTON_DELETE_ACCOUNT_CONFIRM = By.id("delete-account-btn");
    private static final By TEXT_PROFILE_EDITED = By.id("edit-alert");


    public void changeProfile(String name, String bio, String phoneNumber) {
        findElementOnPage(FIELD_NAME).sendKeys(name);
        findElementOnPage(FIELD_BIO).sendKeys(bio);
        findElementOnPage(FIELD_PHONE_NUMBER).sendKeys(phoneNumber);
        findElementOnPage(BUTTON_SAVE_PROFILE).click();
    }

    public boolean verifyProfileChanged() {
        return findElementOnPage(TEXT_PROFILE_EDITED).getText().equals("Profile Edited!");
    }

    public void clickDeleteAccount(){
        findElementOnPage(BUTTON_DELETE_ACCOUNT).click();
    }

    public void clickConfirmDeleteAccount(){
        findElementOnPage(BUTTON_DELETE_ACCOUNT_CONFIRM).click();
    }

}

