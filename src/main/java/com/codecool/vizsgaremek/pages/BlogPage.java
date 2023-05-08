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
    private static final By BUTTON_TITLE_PROJECT_FROM_DECEMBER = By.xpath("//*[@href='https://lennertamas.github.io/roxo/blog/design-inspiration-the-best-projects-from-december/']");
    private static final By TEXT_BLOG_DECEMBER = By.xpath("//*[@class='site-blog-details']");
    private static final By BUTTON_TITLE_PROJECTS_FROM_NOVEMBER = By.xpath("//*[@href='https://lennertamas.github.io/roxo/blog/design-inspiration-the-best-projects-from-november/']");
    private static final By TEXT_BLOG_NOVEMBER = By.xpath("//*[@class='site-blog-details']");



    private static final By BUTTON_BIGGEST_REBRANDS_2019 = By.xpath("//*[@href='https://lennertamas.github.io/roxo/blog/the-10-biggest-rebrands-and-logo-designs-of-2019/']");
    private static final By TEXT_BIGGEST_REBRANDS_2019 = By.xpath("//*[@class='site-blog-details']");
    private static final By BUTTON_TITLE_COLOUR_OF_THE_YEAR_2020 = By.xpath("//*[@href='https://lennertamas.github.io/roxo/blog/pt-chooses-classic-blue-for-its-colour-of-the-year-2020/']");
    private static final By TEXT_BLOG_COLOUR_OF_THE_YEAR_2020 = By.xpath("//*[@class='site-blog-details']");

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

    public void clickBiggestRebrands2019Title() {
        findElementOnPage(BUTTON_BIGGEST_REBRANDS_2019).click();
    }

    public String getBiggestRebrands2019Text() {
        return findElementOnPage(TEXT_BIGGEST_REBRANDS_2019).getText();
    }

    public void clickColourOfTheYear2020Title() {
        findElementOnPage(BUTTON_TITLE_COLOUR_OF_THE_YEAR_2020).click();
    }

    public String getColourOfTheYear2020BlogText() {
        return findElementOnPage(TEXT_BLOG_COLOUR_OF_THE_YEAR_2020).getText();
    }

    public void clickDecemberTitle() {
        findElementOnPage(BUTTON_TITLE_PROJECT_FROM_DECEMBER).click();
    }

    public String getDecemberBlogText() {
        return findElementOnPage(TEXT_BLOG_DECEMBER).getText();
    }

    public void clickNovemberTitle() {
        findElementOnPage(BUTTON_TITLE_PROJECTS_FROM_NOVEMBER).click();
    }

    public String getNovemberBlogText() {
        return findElementOnPage(TEXT_BLOG_NOVEMBER).getText();
    }
}
