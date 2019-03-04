package homeworks.hw7.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.enums.Vegetables;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResultPanel extends WebPage {

    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public void checkResult(int summary, Colors color, Metals metal, Vegetables[] vegetables, NatureElements[] elements) {
        List<String> resultList = resultLog.getAll().stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(resultList.get(0), "Summary: " + summary);
        for (NatureElements element : elements) {
            assertTrue(resultList.get(1).contains(element.toString()));
        }
        assertEquals(resultList.get(2), "Color: " + color.toString());
        assertEquals(resultList.get(3), "Metal: " + metal.toString());
        for (Vegetables vegetable : vegetables){
            assertTrue(resultList.get(4).contains(vegetable.toString()));
        }
    }
}
