package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testUtilities.TestUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SavingDataTest extends TestUtilities {
    @BeforeEach
    void setupPage(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }
    @Test
    @DisplayName("Save 'December blog' text")
    void saveBlogDecember() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        getBlogPage().clickDecemberTitle();

        String newFileName = "src/test/resources/savedFiles/blogDecember.txt";
        String blogDecemberText = getBlogPage().getDecemberBlogText();
        writeTextToFile(blogDecemberText, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getDecemberBlogText(), actualSavedText);
    }

    @Test
    @DisplayName("Save 'November blog' text")
    void saveBlogNovember() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        getBlogPage().clickNovemberTitle();

        String newFileName = "src/test/resources/savedFiles/blogNovember.txt";
        String blogNovemberText = getBlogPage().getNovemberBlogText();
        writeTextToFile(blogNovemberText, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getNovemberBlogText(), actualSavedText);
    }

    @Test
    @DisplayName("Save 'Biggest Rebrands 2019 blog' text")
    void saveBlogBiggestRebrands2019() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        getBlogPage().clickBiggestRebrands2019Title();

        String newFileName = "src/test/resources/savedFiles/blogBiggestRebrands2019.txt";
        String biggestRebrands2019Text = getBlogPage().getBiggestRebrands2019Text();
        writeTextToFile(biggestRebrands2019Text, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getBiggestRebrands2019Text(), actualSavedText);
    }

    @Test
    @DisplayName("Save 'Colour of the year 2020 blog' text")
    void saveBlogColourOfTheYear2020() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        getBlogPage().clickColourOfTheYear2020Title();

        String newFileName = "src/test/resources/savedFiles/blogColourOfTheYear2020.txt";
        String colourOfTheYear2020Text = getBlogPage().getColourOfTheYear2020BlogText();
        writeTextToFile(colourOfTheYear2020Text, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getColourOfTheYear2020BlogText(), actualSavedText);
    }
}
