package stepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceDemoLoginPage;
import utils.Config;
import utils.Driver;

public class LoginDemoSteps {
    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    Faker faker = new Faker();


    @Given("user is on sauce demo login page")
    public void user_is_on_sauce_demo_login_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));

    }
    @When("user provides a valid user name")
    public void user_provides_a_valid_user_name() {
        sauceDemoLoginPage.sauceDemoLoginInputField.sendKeys(Config.getProperty("userName"));

    }
    @When("user provides valid password")
    public void user_provides_valid_password() {
        sauceDemoLoginPage.sauceDemoPasswordInputField.sendKeys(Config.getProperty("password"));

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        sauceDemoLoginPage.sauceDemoLoginButton.click();

    }
    @Then("verify user successfully logged in")
    public void verify_user_successfully_logged_in() {
        Assert.assertEquals(Config.getProperty("expectedUrl"),Driver.getDriver().getCurrentUrl());

    }

    @When("user provides a invalid user name")
    public void user_provides_a_invalid_user_name() {
        sauceDemoLoginPage.sauceDemoLoginInputField.sendKeys(faker.name().firstName());



    }
    @When("user provides invalid password")
    public void user_provides_invalid_password() {
        sauceDemoLoginPage.sauceDemoPasswordInputField.sendKeys(faker.internet().password());

    }
    @Then("verify error message")
    public void verify_error_message() {
    Assert.assertTrue(sauceDemoLoginPage.loginErrorMessage.isDisplayed());

    }





}
