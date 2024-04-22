package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ContinuePage {

    public ContinuePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(xpath = "//h3['Error: First Name is required']")
    public WebElement errorMessage;
    @FindBy(id = "first-name")
    public WebElement firstNameInputField;
    @FindBy(id = "last-name")
    public WebElement lastNameInputField;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInputField;

}
