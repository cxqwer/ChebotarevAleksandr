package homeworks.hw3;

import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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


    public String getUserName() {
        return userName.getText();
    }

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

    public boolean ithemHasText(String text) {
        return items.getText().contains(text);
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

    public boolean checkEpamLogoOfIframe() {
        driver.switchTo().frame(iframe);
        return driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed();
    }

    public boolean leftSectionIsDisplayed() {
        return leftSection.isDisplayed();
    }

    public boolean hasItems() {
        return items.isDisplayed();
    }

    public boolean hasFourImages() {
        return (iconBase.isDisplayed() && iconMulti.isDisplayed() && iconPractise.isDisplayed() && iconСustom.isDisplayed());
    }

    public boolean hasFourTextsOnderIcons() {
        for (WebElement element : benefitText) {
            if (!element.isDisplayed()) return false;
        }
        return true;
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

    public void checkTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void checkNavigationItems(List<String> strings) {
        for (String expected : strings) {
            Assert.assertTrue(items.getText().contains(expected),
                    String.format("%s", expected));
        }
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }
}