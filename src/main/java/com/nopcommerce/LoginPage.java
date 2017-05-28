package com.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @ author Jay Vaghani on 09/04/2017.
 * This is the Login Page
 */
public class LoginPage extends Ulils
{
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }

    @FindBy(id = "Email")
    private WebElement _email;

    @FindBy(id = "Password")
    private WebElement _password;

    @FindBy(css = "input.button-1.login-button")
    private WebElement _loginButton;

    public void loginAsExistingUser()
    {
        new Homepage().clickOnRegistButton();;
        new RegistrationPage().registration();
        new RegistrationPage().clickOnLogoutButton();
        new Homepage().clickOnLoginButton();

        sendText(_email,RegistrationPage.userName);
        sendText(_password,"205madhav");
        clickOnElement(_loginButton);

        // Assert user log in successfully
        assertTrueContains("//a[contains(text(),'Log out')]","xpath","Log out","User not log in successfully");
    }

}
