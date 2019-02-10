package homeworks.hw4.ex2;

import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.SelenideServicePage;
import homeworks.hw4.SelenideSliderPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;

public class SliderPageTest extends SelenideBase {

    private SelenideServicePage servicePage;
    private SelenideSliderPage sliderPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(INDEX_HTML_URL.toString());
        servicePage = page(SelenideServicePage.class);
        sliderPage = page(SelenideSliderPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void tests() {

        //2 Assert Browser title
        servicePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        servicePage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged(Users.PITER);

        //5 Open through the header menu Service -> Dates Page
        servicePage.openHeaderDates(HomePageData.DATES_TITLE);

        //6 set left slider on 0 and right slider on 100
        sliderPage.moveSlidersBoundaryPosition(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(0, 100);

        //8 set left slider on 0 and right slider on 0
        sliderPage.moveSlidersBoundaryPosition(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(0, 0);

        //10 set left slider on 100 and right slider on 100
        sliderPage.moveSlidersBoundaryPosition(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(100, 100);

        //12 set left slider on 30 and right slider on 70
        sliderPage.moveSlidersBoundaryPosition(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(30, 70);

    }
}
