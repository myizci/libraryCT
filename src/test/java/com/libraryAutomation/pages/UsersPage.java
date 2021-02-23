package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage{

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//select[@id='user_groups']")
    public WebElement UserGroupDropdown;

    @FindBy(id = "user_groups")
    public WebElement userGroupDropdown;

}
