package hw2.ex2;

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
        String text = "HOME";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "CONTACT FORM";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "SERVICE";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "METALS & COLORS";
        assertTrue(properText.lastIndexOf(text) >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        cssSelect = "[class='icons-benefit icon-practise']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-custom']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-multi']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-base']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        cssSelect = "[class='benefit-txt']";
        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelect));
        text = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        assertTrue(webElements.get(0).isDisplayed());
        assertTrue(webElements.get(0).getText().equals(text));
        text = "To be flexible and\n" + "customizable";
        assertTrue(webElements.get(1).isDisplayed());
        assertTrue(webElements.get(1).getText().equals(text));
        text = "To be multiplatform";
        assertTrue(webElements.get(2).isDisplayed());
        assertTrue(webElements.get(2).getText().equals(text));
        text = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
        assertTrue(webElements.get(3).isDisplayed());
        assertTrue(webElements.get(3).getText().equals(text));

        //9 Assert a text of the main headers
        cssSelect = "[name='main-title']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "EPAM FRAMEWORK WISHES…";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        cssSelect = "[name='jdi-text']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);

        //10 Assert that there is the iframe in the center of page
        cssSelect = "[id='iframe']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        cssSelect = "[id='iframe']";
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        cssSelect = "a[target='_blank']";
        WebElement webElement = driver.findElement(By.cssSelector(cssSelect));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        cssSelect="[class='footer-bg']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

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
        String text = "HOME";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "CONTACT FORM";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "SERVICE";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "METALS & COLORS";
        assertTrue(properText.lastIndexOf(text) >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        cssSelect = "[class='icons-benefit icon-practise']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-custom']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-multi']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-base']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        cssSelect = "[class='benefit-txt']";
        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelect));
        text = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        assertTrue(webElements.get(0).isDisplayed());
        assertTrue(webElements.get(0).getText().equals(text));
        text = "To be flexible and\n" + "customizable";
        assertTrue(webElements.get(1).isDisplayed());
        assertTrue(webElements.get(1).getText().equals(text));
        text = "To be multiplatform";
        assertTrue(webElements.get(2).isDisplayed());
        assertTrue(webElements.get(2).getText().equals(text));
        text = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
        assertTrue(webElements.get(3).isDisplayed());
        assertTrue(webElements.get(3).getText().equals(text));

        //9 Assert a text of the main headers
        cssSelect = "[name='main-title']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "EPAM FRAMEWORK WISHES…";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        cssSelect = "[name='jdi-text']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);

        //10 Assert that there is the iframe in the center of page
        cssSelect = "[id='iframe']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        cssSelect = "[id='iframe']";
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        cssSelect = "a[target='_blank']";
        WebElement webElement = driver.findElement(By.cssSelector(cssSelect));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        cssSelect="[class='footer-bg']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

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
        String text = "HOME";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "CONTACT FORM";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "SERVICE";
        assertTrue(properText.lastIndexOf(text) >= 0);
        text = "METALS & COLORS";
        assertTrue(properText.lastIndexOf(text) >= 0);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        cssSelect = "[class='icons-benefit icon-practise']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-custom']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-multi']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        cssSelect = "[class='icons-benefit icon-base']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        cssSelect = "[class='benefit-txt']";
        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelect));
        text = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        assertTrue(webElements.get(0).isDisplayed());
        assertTrue(webElements.get(0).getText().equals(text));
        text = "To be flexible and\n" + "customizable";
        assertTrue(webElements.get(1).isDisplayed());
        assertTrue(webElements.get(1).getText().equals(text));
        text = "To be multiplatform";
        assertTrue(webElements.get(2).isDisplayed());
        assertTrue(webElements.get(2).getText().equals(text));
        text = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
        assertTrue(webElements.get(3).isDisplayed());
        assertTrue(webElements.get(3).getText().equals(text));

        //9 Assert a text of the main headers
        cssSelect = "[name='main-title']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "EPAM FRAMEWORK WISHES…";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);
        cssSelect = "[name='jdi-text']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        text = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), text);

        //10 Assert that there is the iframe in the center of page
        cssSelect = "[id='iframe']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        cssSelect = "[id='iframe']";
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        cssSelect = "[class='text-center']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(cssSelect)).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        cssSelect = "a[target='_blank']";
        WebElement webElement = driver.findElement(By.cssSelector(cssSelect));
        assertEquals(webElement.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        cssSelect = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar";
        WebElement leftSection = driver.findElement(By.cssSelector(cssSelect));
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //16 Assert that there is Footer
        cssSelect="[class='footer-bg']";
        assertTrue(driver.findElement(By.cssSelector(cssSelect)).isDisplayed());

        //17 Close Browser
        driver.close();
    }

}
