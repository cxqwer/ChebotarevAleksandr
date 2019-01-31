package homeworks.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;


public class HomeworkSoftTest {

    @Test
    public void tests() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        SoftAssert softAssert = new SoftAssert();

        //1 Open test site by URL
        String url = "https://epam.github.io/JDI/index.html";
        driver.navigate().to(url);

        //2 Assert Browser title
        String title = "Home Page";
        softAssert.assertEquals(driver.getTitle(), title);

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
        softAssert.assertEquals(actualName, expectedName);

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), title);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement navBar = driver.findElement(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']"));
        softAssert.assertTrue(navBar.isDisplayed());
        String actualMenuItems = navBar.getText();
        List<String> itemsTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (String itemsText : itemsTexts) {
            softAssert.assertTrue(actualMenuItems.contains(itemsText));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        String[] cssSelectsIcons = {
                "[class='icons-benefit icon-practise']",
                "[class='icons-benefit icon-custom']",
                "[class='icons-benefit icon-multi']",
                "[class='icons-benefit icon-base']"
        };
        for (String sccSelect : cssSelectsIcons) {
            softAssert.assertTrue(driver.findElement(By.cssSelector(sccSelect)).isDisplayed());
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
        softAssert.assertEquals(webElements.size(), benefitTxt.size());
        for (WebElement element : webElements) {
            softAssert.assertTrue(benefitTxt.contains(element.getText()));
            softAssert.assertTrue(element.isDisplayed());
        }

        //9 Assert a text of the main headers
        WebElement mainTitle = driver.findElement(By.cssSelector("[name='main-title']"));
        softAssert.assertTrue(mainTitle.isDisplayed());
        softAssert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement jdi = driver.findElement(By.cssSelector("[name='jdi-text']"));
        softAssert.assertTrue(jdi.isDisplayed());
        String jdiText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        softAssert.assertEquals(jdi.getText(), jdiText);

        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement header = driver.findElement(By.cssSelector("[class='text-center']"));
        softAssert.assertTrue(header.isDisplayed());
        softAssert.assertEquals(header.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement webElement = driver.findElement(By.cssSelector("a[target='_blank']"));
        softAssert.assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")).isDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //17 Close Browser
        driver.close();
        driver.close();
        softAssert.assertAll();
    }
}
