package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.WebDriver;

public class AboutPage extends Page{

    public AboutPage(WebDriver driver) {
        super(PagesUrl.ABOUT_PAGE.getUrl(), driver);
    }
}
