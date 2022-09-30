package com.todomvc.tests;

import com.todomvc.pages.PolymerPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PolymerTest extends TestBase {

    PolymerPage polymerPage = new PolymerPage();

    @Test
    public void test(){

        polymerPage.getTab("JavaScript").click();
        polymerPage.getLink("Polymer").click();
        String toDoItemOne = "My first to do item";
        String toDoItemTwo = "My second to do item";
        polymerPage.inputBox.sendKeys(toDoItemOne+ Keys.ENTER);
        polymerPage.inputBox.sendKeys(toDoItemTwo + Keys.ENTER);
        Assert.assertTrue(polymerPage.createItemElement(toDoItemOne).isDisplayed(),
       "Verify My First TODO Created");
        Assert.assertTrue(polymerPage.createItemElement(toDoItemTwo).isDisplayed(),
       "Verify My Second TODO Created");

        WebElement btnForChanging = polymerPage.createItemElement(toDoItemTwo);
        actions.doubleClick(btnForChanging).perform();

        for (int i = 0; i < toDoItemTwo.length(); i++) {
             polymerPage.editBox.sendKeys(Keys.BACK_SPACE);
        }

        String changedItem = "I have changed second item";
        polymerPage.editBox.sendKeys(changedItem+Keys.ENTER);
        Assert.assertTrue(polymerPage.createItemElement(changedItem).isDisplayed(),"My second item not changed");


    }
}
