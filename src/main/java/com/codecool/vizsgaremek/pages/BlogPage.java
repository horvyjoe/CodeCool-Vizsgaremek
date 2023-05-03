package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BlogPage extends Page{
    public BlogPage(WebDriver driver) {
        super(PagesUrl.BLOG_PAGE.getUrl(), driver);
    }

    //LOCATORS
    private static final By TEXT_BLOG_TITLE = By.xpath("//h3");
    private static final By BUTTON_NEXT = By.xpath("//*[@aria-label='Next']");

    public String[] findBlogTitles() {
        List<String> collectBlogTitles = new ArrayList<>();
        while (true) {
            List<WebElement> elements = findElementsOnPage(TEXT_BLOG_TITLE);
            for (WebElement element : elements) {
                collectBlogTitles.add(element.getText());
            }
            try {
                findElementOnPage(BUTTON_NEXT).click();
            } catch (ElementNotInteractableException e) {
                break;
            }
        }
        return collectBlogTitles.toArray(new String[0]);
    }

    public void saveBlogPictures() {

    }


}
