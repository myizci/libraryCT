package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ColumnNames_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();

    @Given("the user librarian is on the homepage")
    public void the_user_librarian_is_on_the_homepage() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.login("librarian");
    }


    @When("the user click users module")
    public void the_user_click_users_module() {
        usersPage.usersLink.click();

    }
    @Then("the user should see the following column names:")
    public void the_user_should_see_the_following_column_names(List<String> columnNames) {

       List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.tableHeaders);

        Assert.assertTrue(actualColumnNames.equals(columnNames));

        }

    }




