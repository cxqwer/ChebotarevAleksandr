package homeworks.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressionSmokeGroupsTests {

    @Test(groups = {"Smoke", "Regression"})
    public void tests1() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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
        String assertName = "PITER CHAILOVSKII";
        assertEquals(actualName, actualName);

        //5 Assert Browser title
        title = "Home Page";
        assertEquals(driver.getTitle(), title);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        String cssSelect = "[class='uui-navigation nav navbar-nav m-l8']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        String properText = driver.findElement(By.cssSelector(cssSelect)).getText();
        assertTrue(properText.lastIndexOf("HOME") >= 0);
        assertTrue(properText.lastIndexOf("CONTACT FORM") >= 0);
        assertTrue(properText.lastIndexOf("SERVICE") >= 0);
        assertTrue(properText.lastIndexOf("METALS & COLORS") >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        {
            String[] cssSelects = {
                    "[class='icons-benefit icon-practise']",
                    "[class='icons-benefit icon-custom']",
                    "[class='icons-benefit icon-multi']",
                    "[class='icons-benefit icon-base']"
            };
            for (String sccSelect : cssSelects) {
                assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

            }
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        {
            String[] texts = {
                    "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable",
                    "To be multiplatform",
                    "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
            };
            List<WebElement> webElements = driver.findElements(By.cssSelector("[class='benefit-txt']"));
            assertEquals(webElements.size(), texts.length);
            int i = 0;
            for (WebElement element : webElements) {
                assertEquals(element.getText(), texts[i]);
                assertTrue(element.isDisplayed());
                i++;
            }
        }

        //9 Assert a text of the main headers
        {
            cssSelect = "[name='main-title']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            String text = "EPAM FRAMEWORK WISHES…";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
            cssSelect = "[name='jdi-text']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                    "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                    "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                    "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        }

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement webElement = driver.findElement(By.cssSelector("a[target='_blank']"));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void tests2() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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
        String assertName = "PITER CHAILOVSKII";
        assertEquals(actualName, actualName);

        //5 Assert Browser title
        title = "Home Page";
        assertEquals(driver.getTitle(), title);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        String cssSelect = "[class='uui-navigation nav navbar-nav m-l8']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        String properText = driver.findElement(By.cssSelector(cssSelect)).getText();
        assertTrue(properText.lastIndexOf("HOME") >= 0);
        assertTrue(properText.lastIndexOf("CONTACT FORM") >= 0);
        assertTrue(properText.lastIndexOf("SERVICE") >= 0);
        assertTrue(properText.lastIndexOf("METALS & COLORS") >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        {
            String[] cssSelects = {
                    "[class='icons-benefit icon-practise']",
                    "[class='icons-benefit icon-custom']",
                    "[class='icons-benefit icon-multi']",
                    "[class='icons-benefit icon-base']"
            };
            for (String sccSelect : cssSelects) {
                assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

            }
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        {
            String[] texts = {
                    "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable",
                    "To be multiplatform",
                    "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
            };
            List<WebElement> webElements = driver.findElements(By.cssSelector("[class='benefit-txt']"));
            assertEquals(webElements.size(), texts.length);
            int i = 0;
            for (WebElement element : webElements) {
                assertEquals(element.getText(), texts[i]);
                assertTrue(element.isDisplayed());
                i++;
            }
        }

        //9 Assert a text of the main headers
        {
            cssSelect = "[name='main-title']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            String text = "EPAM FRAMEWORK WISHES…";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
            cssSelect = "[name='jdi-text']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                    "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                    "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                    "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        }

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement webElement = driver.findElement(By.cssSelector("a[target='_blank']"));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void tests3() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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
        String assertName = "PITER CHAILOVSKII";
        assertEquals(actualName, actualName);

        //5 Assert Browser title
        title = "Home Page";
        assertEquals(driver.getTitle(), title);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        String cssSelect = "[class='uui-navigation nav navbar-nav m-l8']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        String properText = driver.findElement(By.cssSelector(cssSelect)).getText();
        assertTrue(properText.lastIndexOf("HOME") >= 0);
        assertTrue(properText.lastIndexOf("CONTACT FORM") >= 0);
        assertTrue(properText.lastIndexOf("SERVICE") >= 0);
        assertTrue(properText.lastIndexOf("METALS & COLORS") >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        {
            String[] cssSelects = {
                    "[class='icons-benefit icon-practise']",
                    "[class='icons-benefit icon-custom']",
                    "[class='icons-benefit icon-multi']",
                    "[class='icons-benefit icon-base']"
            };
            for (String sccSelect : cssSelects) {
                assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

            }
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        {
            String[] texts = {
                    "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable",
                    "To be multiplatform",
                    "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
            };
            List<WebElement> webElements = driver.findElements(By.cssSelector("[class='benefit-txt']"));
            assertEquals(webElements.size(), texts.length);
            int i = 0;
            for (WebElement element : webElements) {
                assertEquals(element.getText(), texts[i]);
                assertTrue(element.isDisplayed());
                i++;
            }
        }

        //9 Assert a text of the main headers
        {
            cssSelect = "[name='main-title']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            String text = "EPAM FRAMEWORK WISHES…";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
            cssSelect = "[name='jdi-text']";
            assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
            text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                    "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                    "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                    "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
            assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        }

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement webElement = driver.findElement(By.cssSelector("a[target='_blank']"));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //17 Close Browser
        driver.close();
    }

}
