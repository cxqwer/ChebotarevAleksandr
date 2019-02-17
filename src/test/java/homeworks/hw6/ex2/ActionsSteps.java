package homeworks.hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw6.ex1.DifferentElemensPageGherkin;
import homeworks.hw6.ex1.HomePageGherkin;

import static com.codeborne.selenide.Selenide.page;

public class ActionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private DifferentElemensPageGherkin differentElementsPage = page(DifferentElemensPageGherkin.class);

    //3Perform login
    @When("^I login as '([^\"]*)'$")
    public void login(Users user) {
        homePage.login(user);
    }

    //6 Click on "Service" subcategory in the header and check that drop down contains options
    @When("^I click on Service subcategory in the header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }


}