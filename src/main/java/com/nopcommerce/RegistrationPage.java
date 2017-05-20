package com.nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class RegistrationPage extends Ulils
{
    RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    static String userName="";

    @FindBy(id = "gender-male")
    private WebElement _male;

    @FindBy(id = "gender-female")
    private WebElement _female;

    @FindBy(id = "FirstName")
    private WebElement _firstName;

    @FindBy(id = "LastName")
    private WebElement _lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement _day;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement _month;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement _year;

    @FindBy(id = "Email")
    private WebElement _email;

    @FindBy(id = "Company")
    private WebElement _company;

    @FindBy(id = "Password")
    private WebElement _password;

    @FindBy(id = "ConfirmPassword")
    private WebElement _confPassword;

    @FindBy(id = "register-button")
    private WebElement _registerButton;

    @FindBy(className = "ico-logout")
    private WebElement _logoutButton;


    // Registration Page Method
    public void registration()
    {
        userName="jaybhavi1"+dateStamp()+"@yahoo.com";
        //Filling User's Personal Details in Every Field
        clickOnElement(_male);
        sendText(_firstName,"Jayendra");
        sendText(_lastName,"Vaghani");
        selectByIndex(_day,14);
        selectByText(_month,"March");
        selectByValue(_year,"1988");
        sendText(_email,userName);
        sendText(_company,"Aum");
        sendText(_password,"205madhav");
        sendText(_confPassword,"205madhav");
        clickOnElement(_registerButton);

    }

    // Click on Log out Button
    public void clickOnLogoutButton()
    {
        clickOnElement(_logoutButton);
        // Assert user should log out successfully
        assertTrueContains("//a[contains(text(),'Log in')]","xpath","Log in","User not Log out Successfully");
    }
}
