package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SauceDemoProductPage {

    public SauceDemoProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backPack;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement addedToCart;
    @FindBy(xpath = "//span[.='1']")
    public WebElement one;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLight;
    @FindBy(xpath = "//span[.='2']")
    public WebElement two;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cartButton;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement tShirt;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesie;






}
