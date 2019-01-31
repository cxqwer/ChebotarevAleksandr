package homeworks.hw3;

import base.SeleniumBase;
import homeworks.hw3.enums.IndexPageIconsData;
import homeworks.hw3.enums.ItemsData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homeworks.hw3.enums.HomePageData.*;

public class PageObjectDesignTest extends SeleniumBase {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void tests() {
        //1 Open test site by URL
        indexPage.open(INDEX_HTML_URL);

        //2 Assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggined(Users.PITER);

        //5 Assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        // TODO Can be simplified, create separate enum
        indexPage.chekItemsTexts(ItemsData.values());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.chekFourthImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        // TODO
        indexPage.chekTextUnderIcons(IndexPageIconsData.values());

        //9 Assert a text of the main headers
        indexPage.chekTextOnMainHeaders(TITLE_ON_MAIN_HEADERS, TEXT_ON_MAIN_HEADERS);

        //10 Assert that there is the iframe in the center of page
        indexPage.IframeIsDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.chekIframeLogo();

        //12 Switch to original window back
        indexPage.switchToDejaultContent();

        //13 Assert a text of the sub header
        indexPage.chekTextOfSubHeader(TEXT_OF_THE_SUB_HEADER);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.chekJdiGit(JDI_GITHUB_URL);

        //15 Assert that there is Left Section
        indexPage.LeftSectionIsDisplayed();

        //16 Assert that there is Footer
        indexPage.FooterIsDisplayed();
    }
}
