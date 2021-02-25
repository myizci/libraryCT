package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @Then("the user should see the following options on userStatus:")
    public void theUserShouldSeeTheFollowingOptionsOnUserStatus(List<String> options) {

        select = new Select(usersPage.statusDropDown);
        List<WebElement> webElements = select.getOptions();
        List<String> actualText = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options,actualText);
    }



  /*  @Given("The librarian is on the homepage")
    public void theLibrarianIsOnTheHomepage() {

    }
    @When("Librarian clicks on Users link")
    public void librarianClicksOnUsersLink() {
    }
    @Then("verify default value should be {int}")
    public void verifyDefaultValueShouldBe(int arg0) {
    }
    @Then("show records for the following counts")
    public void showRecordsForTheFollowingCounts() {
    }
*/
}
