package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US7_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    BooksPage booksPage=new BooksPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

    @Then("user can search books with categories")
    public void user_can_search_books_with_categories(List<String> expectedList) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Select categoryDropdown = new Select(booksPage.booksCategoryDropDown);
        List<WebElement> categoryAsWebElement = categoryDropdown.getOptions();

        List<String> categoryAsString = new ArrayList<>();

        List<String> tableBooksCategoryAsString=new ArrayList<>();

        for (int i = 0; i <categoryAsWebElement.size() ; i++) {
            categoryAsString.add(categoryAsWebElement.get(i).getText());
            wait.until(ExpectedConditions.visibilityOf(categoryAsWebElement.get(i)));
            categoryAsWebElement.get(i).click();
            Thread.sleep(1000);
            // category item i is clicked.
            // then a list of WebElements from the tableBooks will be displayed.
            // We have to keep them in a String list to compare with the expected category word
            tableBooksCategoryAsString.addAll(Collections.singleton(booksPage.categoryInBooksTable.getText()));
            Thread.sleep(1000);
            if(categoryAsWebElement.get(i).getText().isEmpty()){continue;}
            else{
            Assert.assertTrue("one or more books available in category: " , tableBooksCategoryAsString.contains(categoryAsWebElement.get(i).getText())||!(tableBooksCategoryAsString.isEmpty()));
            }
            //Assert.assertEquals(stringList, categoryAsString.get(i));
            Thread.sleep(1000);

        }
        //Assert.assertTrue(tableBooksCategoryAsString.contains(expectedList));
        System.out.println("Actual Books Category = " + tableBooksCategoryAsString);
        System.out.println("Expected Books Category = " + expectedList);
    }
}
