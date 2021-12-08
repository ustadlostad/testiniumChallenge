package com.batur.testiniumchallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageSetup {

    WebDriver driver;
    WebDriverWait wait;

public PageSetup(WebDriver driver, WebDriverWait wait){
    this.driver = driver;
    this.wait = wait;
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

public void checkDisplay(By by){
    boolean displayStatus = driver.findElement(by).isDisplayed();
    if(displayStatus == false){
        Assert.assertTrue(displayStatus);
    }
}

}
