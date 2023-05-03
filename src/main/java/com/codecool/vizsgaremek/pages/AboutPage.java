package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutPage extends Page{

    public AboutPage(WebDriver driver) {
        super(PagesUrl.ABOUT_PAGE.getUrl(), driver);
    }

    // Locators
    private static final By TEXT_TEAM_MEMBER = By.xpath("//*[@class='site-team-member-content']/h3");
    private static final By TEXT_LIST_EXPERTISES = By.xpath("//*[@class='site-expertise-list']/li");
    private static final By CONTENT_ABOUT_ROXO = By.className("site-about-wrapper");

    // Listing team members
    public String[] listTeamMembers() {
        return listData(TEXT_TEAM_MEMBER);
    }

    // Listing expertises
    public String[] listExpertises() {
        return listData(TEXT_LIST_EXPERTISES);
    }

    // get and verify About Roxo Content
    public String getAboutRoxoContent() {
        return findElementOnPage(CONTENT_ABOUT_ROXO).getText();
    }

    // Listing data
    public String[] listData(By locator) {
        List<WebElement> dataElement = findElementsOnPage(locator);
        String[] resultArray = new String[dataElement.size()];
        int count = 0;
        for(WebElement data : dataElement) {
            resultArray[count++] = data.getText();
        }
        return resultArray;
    }
}
