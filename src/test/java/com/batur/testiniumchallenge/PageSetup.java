package com.batur.testiniumchallenge;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PageSetup {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

public PageSetup(WebDriver driver, WebDriverWait wait, Actions action){
    this.driver = driver;
    this.wait = wait;
    this.action = action;
}

public void navigate(String url){
    driver.navigate().to(url);
}

public void click(By by){
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    wait.until(ExpectedConditions.elementToBeClickable(by));
    driver.findElement(by).click();
}

public void setText(String text, By by){
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    for(int i = 0; i < text.length(); i++){
        driver.findElement(by).sendKeys(Character.toString(text.charAt(i)));
    }
}

    public boolean checkElementIsVisible(By by) {
        try {
            driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void pressEnter(By by){
        driver.findElement(by).sendKeys(Keys.RETURN);
    }

    public void selectRandomObjectAndClick(By by){
        Random rnd = new Random();

        List<WebElement> elementList = driver.findElements(by);
        int listSize = elementList.size();
        int randomNumber = rnd.nextInt(listSize);
        WebElement element = elementList.get(randomNumber);
        element.click();
    }

    public void hover(By by) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).perform();
    }

    public String getText(By by) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        return text;
    }

    public String getAttribute(By by, String attribute){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String attributeValue = driver.findElement(by).getAttribute(attribute);
        return attributeValue;
    }

    public void switchTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }


}
