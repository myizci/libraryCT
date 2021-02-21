package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{
    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksLink;
}
