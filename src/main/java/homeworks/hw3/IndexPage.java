package homeworks.hw3;

import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.IndexPageIconsData;
import homeworks.hw3.enums.ItemsData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class IndexPage {

    private WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']")
    private WebElement items;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconСustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(css = "[class='benefit-txt']")
    private List<WebElement> benefitText;

    @FindBy(css = "[name='main-title']")
    private WebElement mainTitle;

    @FindBy(css = "[name='jdi-text']")
    private WebElement jdiText;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[class='text-center']")
    private WebElement textCenter;

    @FindBy(css = "a[target='_blank']")
    private WebElement blank;

    @FindBy(css = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")
    private WebElement leftSection;

    @FindBy(css = "[class='footer-bg']")
    private WebElement footer;

    // TODO Useless methods should be removed.
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToDejaultContent() {
        driver.switchTo().defaultContent();
    }

    public void open(HomePageData url) {
        driver.get(url.toString());
    }

    public void checkTitle(HomePageData title) {
        Assert.assertEquals(driver.getTitle(), title.toString());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLoggined(Users user) {
        assertEquals(userName.getText(), user.name);
    }

    public void chekFourthImages() {
        assertTrue(iconBase.isDisplayed());
        assertTrue(iconMulti.isDisplayed());
        assertTrue(iconPractise.isDisplayed());
        assertTrue(iconСustom.isDisplayed());
    }

    public void chekItemsTexts(ItemsData[] itemsText) {
        assertTrue(items.isDisplayed());
        for (ItemsData item : itemsText) {
            assertTrue(items.getText().contains(item.toString()));
        }
    }

    public void chekTextUnderIcons(IndexPageIconsData[] textUnderIcons) {
        // TODO
        List<String> list = benefitText.stream().map(WebElement::getText).collect(Collectors.toList());
        for (IndexPageIconsData indexPageIconsData : textUnderIcons) {
            assertTrue(list.contains(indexPageIconsData.toString()));
        }
    }

    public void chekTextOnMainHeaders(HomePageData titleOnMainHeaders, HomePageData textOnMainHeaders) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(titleOnMainHeaders.toString(), mainTitle.getText());
        assertTrue(jdiText.isDisplayed());
        assertEquals(textOnMainHeaders.toString(), jdiText.getText());
    }

    public void IframeIsDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void chekIframeLogo() {
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void chekTextOfSubHeader(HomePageData textOfTheSubHeader) {
        assertTrue(textCenter.isDisplayed());
        assertEquals(textCenter.getText(), textOfTheSubHeader.toString());
    }

    public void chekJdiGit(HomePageData jdiGithubUrl) {
        assertEquals(blank.getAttribute("href"), jdiGithubUrl.toString());
    }

    public void LeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void FooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}