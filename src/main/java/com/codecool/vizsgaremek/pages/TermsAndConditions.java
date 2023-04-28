package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditions extends Page{
    public TermsAndConditions(WebDriver driver) {
        super(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }

    // LOCATORS
    // - Terms and conditions
    private static final By BUTTON_ACCEPT_TERMS_AND_CONDITIONS = By.id("terms-and-conditions-button");
    private static final By BUTTON_CLOSE_TERMS_AND_CONDITIONS = By.className("CloseIcon");
    private static final By POPUP_TERMS_AND_CONDITIONS = By.className("popup");
    private static final By AREA_OUTSIDE_TERMS_AND_CONDITIONS = By.xpath("//body");
    private static final By TEXT_TERMS_AND_CONDITIONS = By.xpath("//*[@class='col col-xs-12']");

    // Terms and conditions function

    public void clickAcceptTermsAndConditionsButton() {
        findElementOnPage(BUTTON_ACCEPT_TERMS_AND_CONDITIONS).click();
    }

    public void clickCloseTermsAndConditionsButton() {
        findElementOnPage(BUTTON_CLOSE_TERMS_AND_CONDITIONS).click();
    }

    public boolean validateTermsAndConditionsPopupIsDisplayed() {
        return findElementOnPage(POPUP_TERMS_AND_CONDITIONS).isDisplayed();
    }

    public void clickOutsideTermsAndConditions() {
        findElementOnPage(AREA_OUTSIDE_TERMS_AND_CONDITIONS).click();
    }

    public String getTextTermsAndConditions() {
        return findElementOnPage(TEXT_TERMS_AND_CONDITIONS).getText();
    }


}
