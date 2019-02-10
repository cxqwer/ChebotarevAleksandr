package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.SabcategoryData;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

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

    // TODO This locator should be improved
    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection dropDownService;

    // TODO You should NOT create once single element for each menu items !
    // TODO Use Selenide collection of the element...
    @FindBy(css = "[class='menu-title']")
    private ElementsCollection serviceOnLeftSection;

    @FindBy(css = "[class='sub'] li")
    private ElementsCollection dropDownServiceLeft;

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

    public void checkHeaderService(SabcategoryData[] values) {
        // TODO You can easily verify it with Selenide, take a look on ElementsCollection and Conditions
        serviceOnHeader.shouldHave(visible);
        serviceOnHeader.click();
        dropDownService.shouldHaveSize(values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SabcategoryData::toString).collect(Collectors.toList());
        dropDownService.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    public void checkLeftService(SabcategoryData[] values) {
        serviceOnLeftSection.get(0).shouldHave(visible);
        serviceOnLeftSection.get(0).click();
        // TODO You can easily verify it with Selenide, take a look on ElementsCollection and Conditions
        assertEquals(dropDownServiceLeft.size(), values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SabcategoryData::toString).collect(Collectors.toList());
        dropDownServiceLeft.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    public void openHeaderDifferentElements(HomePageData title) {
        // TODO Basically, you should not find elements in method directly.
        // TODO In this particular case, you can easily select menu item using ElementsCollection
        dropDownService.get(6).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void openHeaderDates(HomePageData title) {
        serviceOnHeader.click();
        dropDownService.get(1).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}