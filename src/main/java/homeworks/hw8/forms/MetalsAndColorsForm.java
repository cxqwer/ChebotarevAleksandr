package homeworks.hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw8.entities.MetalsAndColorsElements;
import org.openqa.selenium.support.FindBy;

import static homeworks.hw8.enums.Vegetables.VEGETABLES;

public class MetalsAndColorsForm extends Form<MetalsAndColorsForm> {

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

    public void fill(MetalsAndColorsElements elements) {
        oddSummary.select(String.valueOf(elements.oddSummary));
        evenSummary.select(String.valueOf(elements.evenSummary));
        for (String element : elements.natureElements) {
            natureElements.select(element);
        }
        colors.select(elements.color);
        metals.select(elements.metal);
        vegetables.select(VEGETABLES.toString());
        for (String vegetable : elements.vegetables) {
            vegetables.select(vegetable);
        }
        submit.click();
    }

}
