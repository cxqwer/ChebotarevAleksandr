package homeworks.hw6.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.SubcategoryData;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageGherkin {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[class='benefit-icon']")
    private ElementsCollection pictures;

    @FindBy(css = "[class='benefit-txt']")
    private ElementsCollection picturesTexts;

    @FindBy(css = "[class='main-title text-center']")
    private SelenideElement headlineText;

    @FindBy(css = "[class='main-txt text-center']")
    private SelenideElement descriptionText;

    @FindBy(css = "[class='menu-title']")
    private ElementsCollection serviceOnLeftSection;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown")
    private SelenideElement serviceOnHeader;

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection dropDownService;

    @FindBy(css = "[class='sub'] li")
    private ElementsCollection dropDownServiceLeft;

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkTitle(HomePageData homePageTitle) {
        assertEquals(getWebDriver().getTitle(), homePageTitle.toString());
    }

    public void checkUserIsLoggined(Users user) {
        userName.shouldHave(visible, text(user.name));
    }

    public void checkElementsExists() {
        pictures.shouldHave(CollectionCondition.size(4));
        for (SelenideElement picture : pictures) {
            picture.should(visible);
        }
        picturesTexts.shouldHave(CollectionCondition.size(4));
        for (SelenideElement pictureText : picturesTexts) {
            pictureText.should(visible);
        }
        headlineText.should(visible);
        descriptionText.should(visible);
    }

    public void clickHeaderService() {
        serviceOnHeader.click();
    }

    public void checkHeaderService(List<SubcategoryData> options) {
        dropDownService.shouldHaveSize(options.size());
        List<String> expectedTexts = options.stream().map(SubcategoryData::toString).collect(Collectors.toList());
        dropDownService.shouldHave(texts(expectedTexts));
    }

    public void clickLeftService() {
        serviceOnLeftSection.get(0).click();
    }

    public void checkLeftService(List<SubcategoryData> options) {
        dropDownServiceLeft.shouldHaveSize(options.size());
        List<String> expectedTexts = options.stream().map(SubcategoryData::toString).collect(Collectors.toList());
        dropDownServiceLeft.shouldHave(texts(expectedTexts));
    }

    public void openPageInServiceOfHeader(SubcategoryData category) {
        dropDownService.get(category.getNumber()-1).click();
    }

//    public void openUserTable() {
//        dropDownService.get(4).click();
//    }
}