package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw3.enums.Users;
import homeworks.hw6.enums.UsersTable;
import homeworks.hw6.ex1.HomePageGherkin;
import homeworks.hw6.ex2.UserTablePage;

import static com.codeborne.selenide.Selenide.page;

public class ActionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void login(Users user) {
        homePage.login(user);
    }

    @When("^I click on Service button in Header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }

    @And("^I click on User Table button in Service dropdown$")
    public void openUserTable() {
        homePage.openUserTable();
    }

    @When("^I select Vip checkbox for '([^\"]*)'$")
    public void selectVip(UsersTable user) {
        userTablePage.clickVip(user);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void clickDropdown(UsersTable user) {
        userTablePage.clickOnDropdown(user);
    }
}