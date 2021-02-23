package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.security.auth.login.Configuration;
import java.util.List;

public class Users_StepDefinitions {
   LoginPage loginPage = new LoginPage();
   UsersPage usersPage = new UsersPage();

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.login("librarian");

    }


    @When("the user click Users module")
    public void the_user_click_users_module() {
        usersPage.usersLink.click();




    }
    @When("the user click User Group dropdown")
    public void the_user_click_user_group_dropdown() {
        usersPage.UserGroupDropdown.click();



    }
    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(List<String> expectedOptions) {
        Select select = new Select(usersPage.userGroupDropdown);
       List<WebElement> list = select.getOptions();

       List<String> actualOptions = BrowserUtils.getElementsText(list);

       Assert.assertEquals(expectedOptions, actualOptions);


    }

}
