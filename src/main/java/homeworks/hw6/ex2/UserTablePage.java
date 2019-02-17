package homeworks.hw6.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.TableUsers;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    public void checkTypeDropdown(int number){
        dropdowns.shouldHaveSize(number);
        for (SelenideElement element: dropdowns){
            element.shouldBe(Condition.visible);
        }
    }

    public void checkUserNames(int number){
        userNames.shouldHaveSize(number);
        for (SelenideElement element:userNames){
            element.shouldBe(Condition.visible);
        }
    }

    public void checkImages(int number){
        images.shouldHaveSize(number);
        for (SelenideElement element: images){
            element.shouldBe(Condition.visible);
        }
    }

    public void checkDescriptionTexts(int number){
        descriptionTexts.shouldHaveSize(number);
        for (SelenideElement element: descriptionTexts){
            element.shouldBe(Condition.visible);
        }
    }

    public void checkCheckboxes(int number){
        checkboxes.shouldHaveSize(number);
        for (SelenideElement element: checkboxes){
            element.shouldBe(Condition.visible);
        }
    }

    public void checkTableElements(TableUsers [] tableUsers){
        List<String> numbs = Arrays.stream(tableUsers).map(TableUsers::getNumberTypeString).collect(Collectors.toList());
        numbers.shouldHaveSize(numbs.size());
        numbers.shouldHave(texts(numbs));
        List<String> users = Arrays.stream(tableUsers).map(TableUsers::getUser).collect(Collectors.toList());
        userNames.shouldHaveSize(users.size());
        userNames.shouldHave(texts(users));
        List<String> descriptions = Arrays.stream(tableUsers).map(TableUsers::getDescription).collect(Collectors.toList());
        descriptionTexts.shouldHaveSize(descriptions.size());
        descriptionTexts.shouldHave(texts(descriptions));
    }

    public void clickVip(TableUsers user){
        checkboxes.get(user.getNumberType()-1).click();
    }

    public void checkVipOnLog(boolean isOn) {
        logs.shouldHave(text("Vip: condition changed to " + isOn));
    }

    public void clickOnDropdown(TableUsers user){
        dropdowns.get(user.getNumberType()).click();
    }

    public void checkDroplistValues(TableUsers user, String [] values){
       String options = dropdowns.get(user.getNumberType()).getText();
        System.out.println(options);
       for (String value:values){
           assertTrue(options.contains(value));
       }
    }

    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}
