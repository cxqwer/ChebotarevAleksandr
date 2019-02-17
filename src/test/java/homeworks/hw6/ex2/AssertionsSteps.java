package homeworks.hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw4.enums.SubcategoryData;
import homeworks.hw6.ex1.DifferentElemensPageGherkin;
import homeworks.hw6.ex1.HomePageGherkin;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private DifferentElemensPageGherkin differentElementsPage = page(DifferentElemensPageGherkin.class);

    //2 Assert Browser title
    @Then("^The browser title should be '([^\"]*)'$")
    public void checkTitle(HomePageData homePageTitle) {
        homePage.checkTitle(homePageTitle);
    }

    //4 Assert User name in the right-top side of screen that user is loggined
    @Then("^User's name should be '([^\"]*)'$")
    public void checkUser(Users user) {
        homePage.checkUserIsLoggined(user);
    }


}