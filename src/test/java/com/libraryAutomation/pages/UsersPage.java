package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage extends BasePage{


    @FindBy(xpath = "//span[.='Users']" )
         public WebElement usersLink;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeaders;

    @FindBy(id = "user_status")
    public WebElement statusDropDown;
}
