package homeworks.hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Hw1TestsWithAnnotations {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void tests() {

        //1 Open test site by URL
        String url = "https://epam.github.io/JDI/index.html";
        driver.navigate().to(url);

        //2 Assert Browser title
        String title = "Home Page";
        assertEquals(driver.getTitle(), title);

        //3 Perform login
        String username = "epam";
        String pass = "1234";
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(username);
        driver.findElement(By.cssSelector("[id='password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        String actualName = driver.findElement(By.cssSelector("[id='user-name'")).getText();
        String expectedName = "PITER CHAILOVSKII";
        assertEquals(actualName, expectedName);

        //5 Assert Browser title
        assertEquals(driver.getTitle(), title);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement navBar = driver.findElement(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']"));
        assertTrue(navBar.isDisplayed());
        String actualMenuItems = navBar.getText();
        List<String> itemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (String itemsText : itemsTexts) {
            assertTrue(actualMenuItems.contains(itemsText));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        String[] cssSelectsIcons = {
                "[class='icons-benefit icon-practise']",
                "[class='icons-benefit icon-custom']",
                "[class='icons-benefit icon-multi']",
                "[class='icons-benefit icon-base']"
        };
        for (String sccSelect : cssSelectsIcons) {
            assertTrue(driver.findElement(By.cssSelector(sccSelect)).isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> benefitTxt = Arrays.asList(
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                        "wish to get more…"
        );
        List<WebElement> webElements = driver.findElements(By.cssSelector("[class='benefit-txt']"));
        assertEquals(webElements.size(), benefitTxt.size());
        for (WebElement element : webElements) {
            assertTrue(benefitTxt.contains(element.getText()));
            assertTrue(element.isDisplayed());
        }

        //9 Assert a text of the main headers
        WebElement mainTitle = driver.findElement(By.cssSelector("[name='main-title']"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement jdi = driver.findElement(By.cssSelector("[name='jdi-text']"));
        assertTrue(jdi.isDisplayed());
        String jdiText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(jdi.getText(), jdiText);

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement header = driver.findElement(By.cssSelector("[class='text-center']"));
        assertTrue(header.isDisplayed());
        assertEquals(header.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement webElement = driver.findElement(By.cssSelector("a[target='_blank']"));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
