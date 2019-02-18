package homeworks.hw6.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.UserTablePageInfo;
import homeworks.hw6.enums.UsersTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class UserTablePage {

    @FindBy(css = "tr > td:first-child")
    private ElementsCollection numbers;

    @FindBy(css = "tr > td > select")
    private ElementsCollection dropdowns;

    @FindBy(css = "tr > td > a")
    private ElementsCollection userNames;

    @FindBy(css = "tr > td > img")
    private ElementsCollection images;

    @FindBy(css = "div.user-descr > span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[class='panel-body-list logs'] > li")
    private SelenideElement logs;

    public void checkTypeDropdown(int number) {
        dropdowns.shouldHaveSize(number);
        for (SelenideElement element : dropdowns) {
            element.shouldBe(Condition.visible);
        }
    }

    public void checkUserNames(int number) {
        userNames.shouldHaveSize(number);
        for (SelenideElement element : userNames) {
            element.shouldBe(Condition.visible);
        }
    }

    public void checkImages(int number) {
        images.shouldHaveSize(number);
        for (SelenideElement element : images) {
            element.shouldBe(Condition.visible);
        }
    }

    public void checkDescriptionTexts(int number) {
        descriptionTexts.shouldHaveSize(number);
        for (SelenideElement element : descriptionTexts) {
            element.shouldBe(Condition.visible);
        }
    }

    public void checkCheckboxes(int number) {
        checkboxes.shouldHaveSize(number);
        for (SelenideElement element : checkboxes) {
            element.shouldBe(Condition.visible);
        }
    }

    public void checkTableElements(List <SuperHero> superHeroes) {
        List<String> numbs = superHeroes.stream().map(SuperHero::getNumber).collect(Collectors.toList());
        numbers.shouldHaveSize(numbs.size());
        numbers.shouldHave(texts(numbs));
        List<String> users = superHeroes.stream().map(SuperHero::getUser).collect(Collectors.toList());
        userNames.shouldHaveSize(users.size());
        userNames.shouldHave(texts(users));
        List<String> descriptions = superHeroes.stream().map(SuperHero::getDesciption).collect(Collectors.toList());
        descriptionTexts.shouldHaveSize(descriptions.size());
        descriptionTexts.shouldHave(texts(descriptions));
    }

    public void clickVip(UsersTable user) {
        checkboxes.get(user.getNumberType() - 1).click();
    }

    public void checkVipOnLog(boolean isOn) {
        logs.shouldHave(text("Vip: condition changed to " + isOn));
    }

    public void clickOnDropdown(UsersTable user) {
        dropdowns.get(user.getNumberType() - 1).click();
    }

    public void checkDroplistValues(List <String> values) {
        ElementsCollection options = dropdowns.get(0).$$("option");
        options.shouldHave(texts(values));
    }

    public void checkTitle(UserTablePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}
