package com.batur.testiniumchallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LandingPage;
import pages.LoginPage;

public class TestSetup {

WebDriver driver;
WebDriverWait wait;

public LandingPage landingPage;
public LoginPage loginPage;

@Parameters("browser")
@BeforeClass
public void setup(String browser){

    if(browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }else if(browser.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }
}

@BeforeMethod
public void beforeMethod(){
landingPage = new LandingPage(driver,wait);
loginPage = new LoginPage(driver,wait);
}

@AfterClass
public void tearDown(){
    if(driver != null){
        driver.quit();
    }
}

}
