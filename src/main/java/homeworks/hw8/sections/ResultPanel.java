package homeworks.hw8.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homeworks.hw8.entities.MetalsAndColorsElements;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResultPanel extends WebPage {

    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public void checkResult(MetalsAndColorsElements selectedElements) {
        List<String> resultList = resultLog.getAll().stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(resultList.get(0), "Summary: " + (selectedElements.oddSummary + selectedElements.evenSummary));
        for (String element : selectedElements.natureElements) {
            assertTrue(resultList.get(1).contains(element));
        }
        assertEquals(resultList.get(2), "Color: " + selectedElements.color);
        assertEquals(resultList.get(3), "Metal: " + selectedElements.metal);
        for (String vegetable : selectedElements.vegetables) {
            assertTrue(resultList.get(4).contains(vegetable));
        }
    }
}
