package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;

public class OpenSiteStep {

    @Given("^I am on Home Page$")
    public void OpenSite() {
        open(INDEX_HTML_URL.toString());
    }
}
