package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertTrue;

public class SelenideSliderPage {

    // TODO It is completely prohibited to create locators in this way ! x2

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection sliders;

    // TODO You can't use such a this 'magic number' in your algorithm
    // TODO Take a look on Math.round
    // TODO Peace of hint: you can organise your algorithm around current values of slider, it will be easier.

    public void moveSlidersBoundaryPosition(int left, int right) {
        assertCorrectValues(left, right);
        SelenideElement leftSlider = sliders.get(0);
        SelenideElement rightSlider = sliders.get(1);
        moveSliderLeftEnd(leftSlider);
        moveSliderRightEnd(rightSlider);
        int step = step();
        moveSliderLeftEnd(rightSlider);
        if (right == 100) {
            moveSliderRightEnd(rightSlider);
        } else {
            moveSlider(rightSlider, right, step);
        }
        if (left == 100) {
            moveSliderRightEnd(leftSlider);
        } else {
            moveSlider(leftSlider, left, step);
        }
    }

    public void moveSliderLeftEnd(SelenideElement slider) {
        actions().dragAndDropBy(slider, -1000, 0).build().perform();

    }

    public void moveSliderRightEnd(SelenideElement slider) {
        actions().dragAndDropBy(slider, 1000, 0).build().perform();
    }

    public void moveSlider(SelenideElement slider, int set, int step) {
        // TODO Pay attention, 100 != 100.0
        int actualValue = Integer.valueOf(slider.getText());
        while (actualValue != set) {
            actions().dragAndDropBy(slider, step, 0).build().perform();
            actualValue = Integer.valueOf(slider.getText());
        }
    }

    public int step() {
        moveSliderRightEnd(sliders.get(1));
        moveSliderLeftEnd(sliders.get(0));
        return (sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX()) / 100;
    }

    public void checkFromAndToInLogs(int left, int right) {
        assertCorrectValues(left, right);
        assertTrue(logs.getText().contains("(To):" + right));
        assertTrue(logs.getText().contains("(From):" + left));
    }

    public void assertCorrectValues(int right, int left) {
        if (left < 0 || left > 100 || right < 0 || right > 100) {
            throw new IllegalArgumentException("The range of the sliders should be in [0, 100]");
        }
    }
}
