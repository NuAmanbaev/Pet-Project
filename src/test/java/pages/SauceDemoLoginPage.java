package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SauceDemoLoginPage {

    public SauceDemoLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
@FindBy(id = "user-name")
    public WebElement sauceDemoLoginInputField;


  @FindBy(xpath = "//input[@id='password']")
  public WebElement sauceDemoPasswordInputField;

  @FindBy(xpath = "//input[@id='login-button']")
    public WebElement sauceDemoLoginButton;

  @FindBy(xpath = "//div[@class='error-message-container error']")
    public WebElement loginErrorMessage;


}
