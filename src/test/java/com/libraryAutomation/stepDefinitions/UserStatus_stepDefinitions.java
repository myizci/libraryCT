package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class UserStatus_stepDefinitions {           //GULISTAN

    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    Select select;

    @Given("the user {string} on the homepage")
    public void the_user_on_the_homepage(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(string);
    }

    @When("the user click users moudle")
    public void the_user_click_users_moudle() {
        usersPage.usersLink.click();
    }

    @And("the user click Status dropdown")
    public void the_user_click_status_dropdown() {
        usersPage.statusDropDown.click();
    }

   // @Then("the user should see the following options:")
   // public void the_user_should_see_the_following_options(List <String> options) {

     //   select = new Select(usersPage.statusDropDown);
       // List<WebElement> webElements = select.getOptions();
        //List<String> actualText = BrowserUtils.getElementsText(webElements);
        //Assert.assertEquals(options,actualText);
    }
