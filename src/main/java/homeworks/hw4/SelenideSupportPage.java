package homeworks.hw4;

import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.SupportData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static org.testng.Assert.*;

// TODO Code conventions
public class SelenideSupportPage {
    // TODO This locator can be improved, most all of them frankly speaking...
    @FindBy(css = "div.uui-main-container.page-inside div.main-content div:nth-child(2)")
    private SelenideElement checkBoxes;

    @FindBy(css = "div.uui-main-container.page-inside div.main-content div:nth-child(3)")
    private SelenideElement radios;

    @FindBy(css = "[class='colors']")
    private SelenideElement dropdown;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "div.uui-main-container.page-inside div.main-content div > input")
    private SelenideElement button;

    @FindBy(css = "[class='uui-side-bar right-fix-panel mCustomScrollbar _mCS_2 mCS_no_scrollbar']")
    private SelenideElement rightSection;

    @FindBy(css = "[class='uui-side-bar mCustomScrollbar _mCS_1 mCS_no_scrollbar']")
    private SelenideElement lefttSection;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = "div.uui-main-container.page-inside div.main-content div.colors select")
    private SelenideElement colorsSelect;

    // TODO In general, You can parametrised the method that working with log,
    // TODO create simple locator that can provide you with the whole log string...

    // TODO Take a look on ElementsCollection:find(...)

    public void chekAllElements() {
        List<SelenideElement> listChekBoxes = checkBoxes.$$("label");
        assertEquals(listChekBoxes.size(), 4);
        for (SelenideElement element : listChekBoxes) {
            element.shouldHave(visible);
        }
        List<SelenideElement> listRadios = checkBoxes.$$("label");
        assertEquals(listChekBoxes.size(), 4);
        for (SelenideElement element : listRadios) {
            element.shouldHave(visible);
        }
        dropdown.shouldHave(visible);
        defaultButton.shouldHave(visible);
        button.shouldHave(visible);
    }

    // TODO Grammar
    public void chekRightSection() {
        rightSection.shouldHave(visible);
    }

    public void chekLeftSection() {
        lefttSection.shouldHave(visible);
    }

    // TODO What kind of 'boxes' you are going to select ?
    // TODO You have to understand that this is an ACTION,
    // TODO it should be referenced on domain, on business function...
    public void selectBoxes(SupportData[] selectedCheckboxes) {
        for (SupportData selectedChexbox : selectedCheckboxes) {
            checkBoxes.$(byText(selectedChexbox.toString())).click();
        }
    }

    public void chekChekboxesTrueInLog(SupportData[] selectedCheckboxes) {
        for (SupportData selectedChekbox: selectedCheckboxes){
            assertTrue(checkboxInLog(selectedChekbox.toString()));
        }
    }

    public boolean checkboxInLog(String ratioName) {
        List<String> logMessages = logs.$$("li").texts();
        for (String message : logMessages) {
            if (message.contains(ratioName)){
                return message.contains("true");
            }
        }
        return false;
    }

    public String ratioInLog() {
        List<String> logMessages = logs.$$("li").texts();
        for (String message : logMessages) {
            if (message.contains("metal")){
                return message.substring(message.lastIndexOf(" ")+1);
            }
        }
        return null;
    }

    public void selectRadio(SupportData firstRadio) {
        radios.$(byText(firstRadio.toString())).click();
    }

    public void chekRadioLogValue(SupportData radio) {
        assertEquals(ratioInLog(), radio.toString());
    }

    public void selectDropdown(SupportData fourthDropdown) {
        colorsSelect.click();
        colorsSelect.$(byText(fourthDropdown.toString())).click();
    }

    public String colorInLog(){
        List<String> logMessages = logs.$$("li").texts();
        for (String message : logMessages) {
            if (message.contains("Colors")){
                return message.substring(message.lastIndexOf(" ")+1);
            }
        }
        return null;
    }

    public void chekSelectedColor(SupportData fourthDropdown) {
        assertEquals(colorInLog(), fourthDropdown.toString());
    }

    public void chekChekboxesFalseInLog(SupportData[] selectedCheckboxes) {
        for (SupportData selectedChekbox: selectedCheckboxes){
            assertFalse(checkboxInLog(selectedChekbox.toString()));
        }
    }

}
