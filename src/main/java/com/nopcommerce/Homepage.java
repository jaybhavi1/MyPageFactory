package com.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class Homepage extends Ulils
{
//    public Homepage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }

    @FindBy(id = "customerCurrency")
    WebElement _selectCurrency;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement _registerButton;

    @FindBy(className = "ico-login")
    WebElement _loginButton;

    @FindBy(xpath = "//a[@class='ico-wishlist']/span[1]")
    WebElement _wishListButton;

    @FindBy(css = "span.cart-label")
    WebElement _shoppingCartButton;

    @FindBy(css = "input.button-1.cart-button")
    WebElement _shoppingCartBtton_1;

    @FindBy(linkText = "Computers")
    WebElement _computersTab;

    @FindBy(xpath = "//ul[@class='top-menu']/li[2]/a")
    WebElement _electronicsTab;



    public void clickOnComputerTab(){
        clickOnElement(_computersTab);
    }

    public void clickOnRegistButton()
    {
        clickOnElement(_registerButton);
    }

    public void selectCurrency(){
        selectByText(_selectCurrency,"Euro");
        // Assert that Euro is selected
        assertTrueContains("//option[text()='Euro']","xpath","Euro","Euro is not selected");
    }
    // click on Register Button on Top Menu
    public void clickOnRegisterButton()
    {
        // click on Register Button from top menu
        clickOnElement(_registerButton);

        // Verify that user is navigate to Registration page Successfully
        assertTrueContains("//div[@class='page-title']/h1","xpath","Register","User not navigate to Register page");
    }
    //click on Login Button n top menu
    public void clickOnLoginButton()
    {
        clickOnElement(_loginButton);
        // Verify that user should navigate to Login page
        assertTrueContains("page-title","class","Welcome, Please Sign In!","User not navigate SignIn page");
    }

    //Click on WishList Button on Top Menu
    public void clickOnWishList()
    {
        clickOnElement(_wishListButton);

        // Verify that User should navigate to wish list page
        assertTrueContains("h1","css","Wishlist","User not navigate to WishList page");
    }

    // Click on Shopping Cart Button
    public void goToShoppingCart()
    {
        // Go to shopping cart from green bar
        mouseHover(_shoppingCartButton);
        clickOnElement(_shoppingCartBtton_1);

        // Verify that User navigate to Shopping Cart Page
        assertTrueContains("page-title","class","Shopping cart","User is not navigate to Shopping cart");

    }

    // click on Computers categories
    public void clickOnComputers()
    {
        clickOnElement(_computersTab);

        //Assert User Mover to Computers Page
        assertTrueContains("page-title","class","Computers","User not navigate to Computers Page");
    }

    // click on Electronics categories
    public void clickOnElectronics()
    {
        clickOnElement(_electronicsTab);

        // Verify that user should navigate to Electronics Page
        assertTrueContains("page-title","class","Electronics","User not navigate to Electronics Page");

    }



}
