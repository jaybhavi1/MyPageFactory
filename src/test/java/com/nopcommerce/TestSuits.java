package com.nopcommerce;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class TestSuits extends BaseTest
{
    Homepage homepage ;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    Ulils ulils = new Ulils();

    @BeforeClass
    public void beforeClass(){
        homepage= new Homepage();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
    }


    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        homepage.clickOnComputerTab();
        ulils.assertTrueContains("page-title","class","Computers","User not navigate to Computers Page");
    }

    @Test
    public void userShouldChangeCurrencyDollerToEuroSuccessfully(){
        homepage.selectCurrency();
        ulils.assertTrueContains("//option[text()='Euro']","xpath","Euro","Euro is not selected");
    }

    @Test
    public void userShouldLogInSuccessfully()
    {
        // Login as Existing User on Login Page
        loginPage.loginAsExistingUser();

        // Verify that User should login Successfully
        ulils.assertTrueContains("ico-account", "class","My account",  "User is not Login ");
    }

    @Test
    public void userShouldRegisterSuccessfully()
    {
        homepage.clickOnRegistButton();
        registrationPage.registration();
        ulils.assertTrueContains("result","class","Your registration completed","User is not register successfully");
    }
}
