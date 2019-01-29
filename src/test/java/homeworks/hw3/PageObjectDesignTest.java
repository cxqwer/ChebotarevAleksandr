package homeworks.hw3;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static java.lang.System.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectDesignTest extends SeleniumBase {

    private WebDriver driver;
    private IndexPage indexPage;
    private SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, homeworks.hw3.IndexPage.class);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        softAssert.assertAll();
    }

    @Test
    public void tests() {
        //1 Open test site by URL
        indexPage.open("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        softAssert.assertEquals(indexPage.getTitle(), "Home Page");

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(indexPage.getUserName(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(indexPage.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(indexPage.hasItems());
        softAssert.assertTrue(indexPage.ithemHasText("HOME"));
        softAssert.assertTrue(indexPage.ithemHasText("CONTACT FORM"));
        softAssert.assertTrue(indexPage.ithemHasText("SERVICE"));
        softAssert.assertTrue(indexPage.ithemHasText("METALS & COLORS"));

        //7 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(indexPage.hasFourImages());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertTrue(indexPage.hasFourTextsOnderIcons());
        String text = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        softAssert.assertTrue(indexPage.getBenefitText(0).equals(text));
        text = "To be flexible and\n" + "customizable";
        softAssert.assertTrue(indexPage.getBenefitText(1).equals(text));
        text = "To be multiplatform";
        softAssert.assertTrue(indexPage.getBenefitText(2).equals(text));
        text = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
        softAssert.assertTrue(indexPage.getBenefitText(3).equals(text));

        //9 Assert a text of the main headers
        softAssert.assertTrue(indexPage.mainTitleIsDisplayed());
        softAssert.assertEquals(indexPage.getMainTitle(), "EPAM FRAMEWORK WISHES…");

        softAssert.assertTrue(indexPage.jdiTextIsDisplayed());
        text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        softAssert.assertEquals(indexPage.getJdiText(), text);

        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(indexPage.iframeDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe

        softAssert.assertTrue(indexPage.checkEpamLogoOfIframe());

        //12 Switch to original window back
        indexPage.switchToDejaultContent();

        //13 Assert a text of the sub header
        softAssert.assertTrue(indexPage.textCenterIsDisplayed());
        softAssert.assertEquals(indexPage.getTextCenter(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(indexPage.getBlankAttribute(), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        softAssert.assertTrue(indexPage.leftSectionIsDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(indexPage.footerIdDisplayed());
    }
}
