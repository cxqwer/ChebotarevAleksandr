package homeworks.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.ServiceSubcategoryData;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SelenideServicePage {

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown")
    private SelenideElement serviceOnHeader;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown.open ul")
    private SelenideElement dropDownService;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3)")
    private SelenideElement serviceOnLeftSection;

    @FindBy (css = "#mCSB_1_container ul li:nth-child(3) > ul")
    private SelenideElement dropDownServiceLeft;

    public void open(HomePageData url) {
        Selenide.open(url.toString());
    }

    public void checkTitle(HomePageData title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLogged(Users user) {
        userName.shouldHave(visible, text(user.name));
    }

    public void checkHeaderService(ServiceSubcategoryData[] values) {
        serviceOnHeader.shouldHave(visible);
        serviceOnHeader.click();
        dropDownService.shouldHave(visible);
        List<String> list = dropDownService.$$("li").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertEquals(values.length, list.size());
        for (ServiceSubcategoryData value : values) {
            assertTrue(list.contains(value.toString().toUpperCase()));
        }
        serviceOnHeader.click();
    }

    public void checkLeftService(ServiceSubcategoryData[] values) {
        serviceOnLeftSection.shouldHave(visible);
        serviceOnLeftSection.click();
        dropDownServiceLeft.shouldHave(visible);
        List<String> list = dropDownServiceLeft.$$("li").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertEquals(values.length, list.size());
        for (ServiceSubcategoryData value : values) {
            assertTrue(list.contains(value.toString()));
        }
        serviceOnHeader.click();
    }

    public void openHeaderDifferentElements(HomePageData title) {
        dropDownService.$("li:nth-child(7)").click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void openHeaderDates(HomePageData title) {
        serviceOnHeader.click();
        dropDownService.$("li:nth-child(2)").click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}