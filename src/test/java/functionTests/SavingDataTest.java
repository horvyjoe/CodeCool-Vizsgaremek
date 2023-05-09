package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("'Saving data' functions - These tests covers the verification of saving data from pages.")
public class SavingDataTest extends TestUtilities {
    @BeforeEach
    void setUpPreconditionSteps(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().typeBuiltInLoginCredentials();
        getRegistrationAndLoginPage().clickLoginButton();
    }

    @Test
    @Tag("SAV01")
    @Description("Saving text of 'December blog'")
    @Story("Saving text - User is saving the text of 'December blog' to blogDecember.txt.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Save 'December blog' text")
    void saveBlogDecember() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"This is not the correct blog page!");
        getBlogPage().clickDecemberTitle();

        String newFileName = "src/test/resources/savedFiles/blogDecember.txt";
        String blogDecemberText = getBlogPage().getDecemberBlogText();
        writeTextToFile(blogDecemberText, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getDecemberBlogText(), actualSavedText,"Text of saved file is not identical to the text of the target blog page!");
    }

    @Test
    @Tag("SAV02")
    @Description("Saving text of 'November blog'")
    @Story("Saving text - User is saving the text of 'November blog' to blogNovember.txt.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Save 'November blog' text")
    void saveBlogNovember() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"This is not the correct blog page!");
        getBlogPage().clickNovemberTitle();

        String newFileName = "src/test/resources/savedFiles/blogNovember.txt";
        String blogNovemberText = getBlogPage().getNovemberBlogText();
        writeTextToFile(blogNovemberText, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getNovemberBlogText(), actualSavedText,"Text of saved file is not identical to the text of the target blog page!");
    }

    @Test
    @Tag("SAV03")
    @Description("Saving text of 'Biggest Rebrands 2019 blog'")
    @Story("Saving text - User is saving the text of 'Biggest Rebrands 2019 blog' to blogBiggestRebrands2019.txt.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Save 'Biggest Rebrands 2019 blog' text")
    void saveBlogBiggestRebrands2019() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"This is not the correct blog page!");
        getBlogPage().clickBiggestRebrands2019Title();

        String newFileName = "src/test/resources/savedFiles/blogBiggestRebrands2019.txt";
        String biggestRebrands2019Text = getBlogPage().getBiggestRebrands2019Text();
        writeTextToFile(biggestRebrands2019Text, newFileName);

        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getBiggestRebrands2019Text(), actualSavedText,"Text of saved file is not identical to the text of the target blog page!");
    }

    @Test
    @Tag("SAV03")
    @Description("Saving text of 'Colour of the year 2020 blog'")
    @Story("Saving text - User is saving the text of 'Colour of the year 2020 blog' to blogColourOfTheYear2020.txt.")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Save 'Colour of the year 2020 blog' text")
    void saveBlogColourOfTheYear2020() throws IOException {
        getLandingPage().clickBlogButton();
        Assertions.assertEquals(PagesUrl.BLOG_PAGE.getUrl(), driver.getCurrentUrl(),"This is not the correct blog page!");
        getBlogPage().clickColourOfTheYear2020Title();

        String newFileName = "src/test/resources/savedFiles/blogColourOfTheYear2020.txt";
        String colourOfTheYear2020Text = getBlogPage().getColourOfTheYear2020BlogText();
        writeTextToFile(colourOfTheYear2020Text, newFileName);
        String actualSavedText = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(getBlogPage().getColourOfTheYear2020BlogText(), actualSavedText,"Text of saved file is not identical to the text of the target blog page!");
    }
}
