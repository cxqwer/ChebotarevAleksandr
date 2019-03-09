package homeworks.hw8.pages;

import base.jdi.entities.User;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Menu;
import homeworks.hw8.enums.HeaderElements;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

@JSite("https://epam.github.io/JDI/")
@Url("index.html")
@Title("Home Page")
public class IndexPageJdi extends WebPage {
    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='user-name']")
    private TextField userName;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    public Menu navigation;

    private LoginForm loginForm;

    public void login(User user) {
        loginIcon.click();
        loginForm.loginAs(user);
    }

    public void checkUserIsLogged(User user) {
        assertEquals(userName.getText(), user.name);
    }

    public void openInHeader(HeaderElements headerElement)
    {
        navigation.select(headerElement.toString());
    }

}
