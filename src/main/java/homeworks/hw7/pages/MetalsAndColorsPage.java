package homeworks.hw7.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.enums.MetalsAndColorsData;
import homeworks.hw7.enums.Vegetables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = "#odds-selector p")
    public RadioButtons oddSummary;

    @FindBy(css = "#even-selector p")
    public RadioButtons evenSummary;

    @JDropdown(root = "div[ui=combobox]", value = "input",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "div[ui=droplist]", value = "input:checked",
            list = "li", expand = ".caret")
    public Droplist vegetables;

    @Css(".vertical-group p")
    public WebList natureElements;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public void checkTitle(MetalsAndColorsData Title) {
        assertEquals(getTitle(), Title.toString());
    }

    public void checkIsOpen() {
        assertTrue(this.isOpened());
    }

    public void selectSummary(int first, int second) {
        oddSummary.select(String.valueOf(first));
        evenSummary.select(String.valueOf(second));
    }

    public void selectNatureElements(NatureElements[] elements) {
        for (NatureElements element : elements) {
            natureElements.select(element.toString());
        }
    }

    public void selectColor(Colors color) {
        colors.select(color.toString());
    }

    public void selectMetal(Metals metal) {
        this.metals.select(metal.toString());
    }

    public void clickVegetable(Vegetables vegetable) {
        this.vegetables.select(vegetable.toString());
    }

    public void selectVegetables(Vegetables[] vegetables) {
        for (Vegetables vegetable : vegetables) {
            this.vegetables.select(vegetable.toString());
        }
    }

    public void clickSubmit() {
        submit.click();
    }

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