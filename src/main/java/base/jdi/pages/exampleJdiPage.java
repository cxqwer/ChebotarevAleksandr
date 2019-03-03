package base.jdi.pages;

import base.jdi.entities.User;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;

public class exampleJdiPage extends WebPage {
    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    LoginForm loginForm;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }
}
