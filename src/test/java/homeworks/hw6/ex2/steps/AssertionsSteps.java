package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw6.enums.UserTablePageInfo;
import homeworks.hw6.ex1.HomePageGherkin;
import homeworks.hw6.ex2.SuperHero;
import homeworks.hw6.ex2.UserTablePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private UserTablePage userTablePag = page(UserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(UserTablePageInfo title) {
        userTablePag.checkTitle(title);
    }

    @And("^'([^\"]*)' NumberType Dropdown are displayed on User Table Page$")
    public void checkDropdown(int number) {
        userTablePag.checkTypeDropdown(number);
    }

    @And("^'([^\"]*)' User names are displayed on Users Table on User Table Page$")
    public void checkUserNames(int number) {
        userTablePag.checkUserNames(number);
    }

    @And("^'([^\"]*)' Description images are displayed on Users Table on User Table Page$")
    public void checkImages(int number) {
        userTablePag.checkImages(number);
    }

    @And("^'([^\"]*)' Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTexts(int number) {
        userTablePag.checkDescriptionTexts(number);
    }

    @And("^'([^\"]*)' checkboxes are displayed on Users Table on User Table Page$")
    public void checkCheckboxes(int number) {
        userTablePag.checkCheckboxes(number);
    }

    @And("^User table contains following values:$")
    public void check(List<SuperHero> superHeroes) {
        userTablePag.checkTableElements(superHeroes);
    }

    @Then("^I check condition in log section changed to '([^\"]*)'$")
    public void checkVipOnLog(boolean isOn) {
        userTablePag.checkVipOnLog(isOn);
    }

    @Then("^Droplist contains values:$")
    public void checkDroplist(List<String> values) {
        userTablePag.checkDroplistValues(values);
    }
}