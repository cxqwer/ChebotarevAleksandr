package homeworks.hw8;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import homeworks.hw8.entities.MetalsAndColorsElements;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static homeworks.hw8.JdiSite.indexPage;
import static homeworks.hw8.JdiSite.metalsAndColorsPage;
import static homeworks.hw8.enums.HeaderElements.METALS_AND_COLORS;
import static homeworks.hw8.enums.MetalsAndColorsData.TITLE;

public class JdiPageTestWithDP {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @AfterMethod
    public void afterMethod(){
        WebDriverFactory.getDriver().manage().deleteAllCookies();
    }

    @DataProvider
    public Object[][] dataProvider() throws FileNotFoundException {
        JsonObject jsonMap = new JsonParser()
                .parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject();
        Object[][] returnedArray = new Object[jsonMap.size()][1];
        int i= 0;
        for (Map.Entry<String, JsonElement> entry : jsonMap.entrySet()) {
            returnedArray[i++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsAndColorsElements.class);
        }
        return returnedArray;
    }

    @Test(dataProvider = "dataProvider")
    public void test(MetalsAndColorsElements selectedElements) {
        // 1 Login on JDI site as User: Piter_Chailovskii
        System.out.println();
        indexPage.open();
        indexPage.login(User.PITER);
        indexPage.checkUserIsLogged(User.PITER);

        // 2 Open Metals&Colors page by Header menu
        indexPage.openInHeader(METALS_AND_COLORS);
        metalsAndColorsPage.checkIsOpen();
        metalsAndColorsPage.checkTitle(TITLE);

        // 3 Fill form Metals & Colors
        metalsAndColorsPage.fillForm(selectedElements);

        // 4 Check results sections
        metalsAndColorsPage.checkResult(selectedElements);
    }
}
