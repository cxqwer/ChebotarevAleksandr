package homeworks.hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.entities.MetalsAndColorsElements;
import homeworks.hw7.enums.Vegetables;
import org.openqa.selenium.support.FindBy;

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

    public void fill(MetalsAndColorsElements elements) {
        oddSummary.select(String.valueOf(elements.getOddSummary()));
        evenSummary.select(String.valueOf(elements.getEvenSummary()));
        for (NatureElements element : elements.getNatureElements()) {
            natureElements.select(element.toString());
        }
        colors.select(elements.getColor().toString());
        metals.select(elements.getMetal().toString());
        for (Vegetables vegetable : elements.getVegetables()) {
            vegetables.select(vegetable.toString());
        }
    }

    public void clickVegetable(Vegetables vegetable) {
        this.vegetables.select(vegetable.toString());
    }

}
