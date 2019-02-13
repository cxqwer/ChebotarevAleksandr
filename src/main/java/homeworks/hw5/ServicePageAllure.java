package homeworks.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.SubcategoryData;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class ServicePageAllure {

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

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection dropDownService;

    @FindBy(css = "[class='menu-title']")
    private ElementsCollection serviceOnLeftSection;

    @FindBy(css = "[class='sub'] li")
    private ElementsCollection dropDownServiceLeft;

    @Step("Open site by URL")
    public void open(HomePageData url) {
        Selenide.open(url.toString());
    }

    @Step("Assert Browser title")
    public void checkTitle(HomePageData title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    @Step("Perform login")
    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Assert user is lagged")
    public void checkUserIsLogged(Users user) {
        userName.shouldHave(visible, text(user.name));
    }

    @Step("Check drop downs options in header")
    public void checkHeaderService(SubcategoryData[] values) {
        serviceOnHeader.shouldHave(visible);
        serviceOnHeader.click();
        dropDownService.shouldHaveSize(values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SubcategoryData::toString).collect(Collectors.toList());
        dropDownService.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    @Step("Check drop down options in left section")
    public void checkLeftService(SubcategoryData[] values) {
        serviceOnLeftSection.get(0).shouldHave(visible);
        serviceOnLeftSection.get(0).click();
        assertEquals(dropDownServiceLeft.size(), values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SubcategoryData::toString).collect(Collectors.toList());
        dropDownServiceLeft.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    @Step("Open Different Elements Page")
    public void openPageHeaderMenu(SubcategoryData item) {
        dropDownService.find(text(item.toString())).click();
    }

    @Step("Open Data Page")
    public void openHeaderDates(HomePageData title) {
        serviceOnHeader.click();
        dropDownService.get(1).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}