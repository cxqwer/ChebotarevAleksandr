package homeworks.hw3;

import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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
    public String getMainTitle() {
        return mainTitle.getText();
    }

    public String getJdiText() {
        return jdiText.getText();
    }

    public String getTextCenter() {
        return textCenter.getText();
    }

    public String getBenefitText(int index) {
        return benefitText.get(index).getText();
    }

    public String getBlankAttribute() {
        return blank.getAttribute("href");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean mainTitleIsDisplayed() {
        return mainTitle.isDisplayed();
    }

    public boolean jdiTextIsDisplayed() {
        return jdiText.isDisplayed();
    }

    public boolean iframeDisplayed() {
        return iframe.isDisplayed();
    }

    public boolean textCenterIsDisplayed() {
        return textCenter.isDisplayed();
    }

    public boolean footerIdDisplayed() {
        return footer.isDisplayed();
    }

    public boolean leftSectionIsDisplayed() {
        return leftSection.isDisplayed();
    }

    public boolean hasFourImages() {
        return (iconBase.isDisplayed() && iconMulti.isDisplayed() && iconPractise.isDisplayed() && iconСustom.isDisplayed());
    }

    public void switchToDejaultContent() {
        driver.switchTo().defaultContent();
    }

    public void open(HomePageData url) {
        driver.get(url.toString());
    }

    public IndexPage(WebDriver driver) {
        this.driver = driver;
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
        assertTrue(hasFourImages());
    }

    public void chekItemsTexts(HomePageData[] itemsText) {
        assertTrue(items.isDisplayed());
        for (HomePageData item : itemsText) {
            assertTrue(items.getText().contains(item.toString()));
        }
    }

    public void chekTextUnderIcons(HomePageData[] textUnderIcons) {
        // TODO
        int i = 0;
        for (HomePageData text : textUnderIcons) {
            assertEquals(text.toString(), getBenefitText(i));
            i++;
        }
    }

    public void chekTextOnMainHeaders(HomePageData titleOnMainHeaders, HomePageData textOnMainHeaders) {
        assertTrue(mainTitleIsDisplayed());
        assertEquals(titleOnMainHeaders.toString(), getMainTitle());
        assertTrue(jdiTextIsDisplayed());
        assertEquals(textOnMainHeaders.toString(), getJdiText());
    }

    public void chekIframe() {
        assertTrue(iframeDisplayed());
    }

    public void chekIframeLogo() {
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void chekTextOfSubHeader(HomePageData textOfTheSubHeader) {
        assertTrue(textCenterIsDisplayed());
        assertEquals(getTextCenter(), textOfTheSubHeader.toString());
    }

    public void chekJdiGit(HomePageData jdiGithubUrl) {
        assertEquals(getBlankAttribute(), jdiGithubUrl.toString());
    }

    public void chekLeftSection() {
        assertTrue(leftSectionIsDisplayed());
    }

    public void chekFooter() {
        assertTrue(footerIdDisplayed());
    }
}