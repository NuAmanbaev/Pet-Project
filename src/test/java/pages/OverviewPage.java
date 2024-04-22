package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class OverviewPage {

    public OverviewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='cart_item_label']")
    public WebElement finalProduct;
    @FindBy(xpath = "//button[.='Finish']")
    public WebElement finishButton;




}
