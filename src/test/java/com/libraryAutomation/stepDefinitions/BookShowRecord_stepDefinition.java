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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookShowRecord_stepDefinition {
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    Select select;

    @Given("User  librarian is on the homepage")
    public void user_librarian_is_on_the_homepage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.login("librarian");


    }



    @When("User click on {string} link")
    public void user_click_on_link(String string) {
        usersPage.usersLink.click();

    }
    @Then("User verify that the default record is {int}")
    public void user_verify_that_the_default_record_is(Integer defaultValue) {
        UsersPage.getDefaultValue(defaultValue);
    }


    @Then("User sees show records for the following count")
    public void user_sees_show_records_for_the_following_count() {

        Select select = new Select(usersPage.getShowRecords);
        List<WebElement> webElements = select.getOptions();
        List<String> actualTexts = BrowserUtils.getElementsText(webElements);
        boolean options = false;
        Assert.assertEquals("Failed, Asssertion failed on option",options,actualTexts);
        System.out.println(actualTexts);
        System.out.println(options);




    }

}
