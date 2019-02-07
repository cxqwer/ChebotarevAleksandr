package homeworks.hw4.ex2;

import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import homeworks.hw3.enums.Users;
import homeworks.hw4.SelenideServicePage;
import homeworks.hw4.SelenideSliderPage;
import homeworks.hw4.enums.SliderData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;

public class SliderPageTest extends SelenideBase {

    private SelenideServicePage servicePage;
    private SelenideSliderPage sliderPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(INDEX_HTML_URL.toString());
        getWebDriver().manage().window().maximize();
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
        servicePage.checkUserIsLoggined(Users.PITER);

        //5 Open through the header menu Service -> Dates Page
        servicePage.openHeaderDates(SliderData.TITLE);

        // TODO The range of the slider is [0, 100] so you can't go beyond ...
        //6 set left slider on 0 and right slider on 100
        sliderPage.moveSlidersBoundryPosition(-1000, 1000);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        // TODO It is not make sense to store one of the data in enum and one of them as is
        // TODO You have to following with one approach
        sliderPage.chekFromAndToInLogs(SliderData.ZERO, SliderData.HUNDRED);

        //8 set left slider on 0 and right slider on 0
        sliderPage.moveSlidersBoundryPosition(-1000, -1000);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.chekFromAndToInLogs(SliderData.ZERO, SliderData.ZERO);

        //10 set left slider on 100 and right slider on 100
        sliderPage.moveSlidersBoundryPosition(1000, 1000);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.chekFromAndToInLogs(SliderData.HUNDRED, SliderData.HUNDRED);

        //12 set left slider on 30 and right slider on 70
        sliderPage.moveSlidersBoundryPosition(-70, -30);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.chekFromAndToInLogs(SliderData.THIRTY, SliderData.SEVENTY);

    }
}
