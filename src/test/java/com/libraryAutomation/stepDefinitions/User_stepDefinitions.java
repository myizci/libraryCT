package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class User_stepDefinitions {
    UsersPage usersPage = new UsersPage();

    @When("user navigate to Users page")
    public void user_navigate_to_users_page() {
        usersPage.navigateToUsersPage();
    }

    @And("use add a new user")
    public void user_add_a_new_user() {
        usersPage.addUser();
    }

    @Then("user can edit new user")
    public void user_can_edit_new_user(){
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForVisibility(usersPage.editFirstUser,5);
        usersPage.editFirstUser.click();
        BrowserUtils.waitForVisibility(usersPage.editUserInfoTitle,5);
        Assert.assertTrue(usersPage.editUserInfoTitle.isDisplayed());
        usersPage.closeButton.click();
        Assert.assertTrue(usersPage.userManagementTitle.isDisplayed());
    }

}
