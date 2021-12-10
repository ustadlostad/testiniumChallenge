package com.batur.testiniumchallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

public class TestSetup {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public LandingPage landingPage;
    public LoginPage loginPage;
    public MainPage mainPage;
    public ListPage listPage;
    public ItemDetailPage itemDetailPage;
    public BasketPage basketPage;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            driver = new ChromeDriver(ops);
            action = new Actions(driver);
            wait = new WebDriverWait(driver, 10);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            action = new Actions(driver);
            wait = new WebDriverWait(driver, 10);
            driver.manage().window().maximize();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        landingPage = new LandingPage(driver, wait, action);
        loginPage = new LoginPage(driver, wait, action);
        mainPage = new MainPage(driver, wait, action);
        listPage = new ListPage(driver, wait, action);
        itemDetailPage = new ItemDetailPage(driver, wait, action);
        basketPage = new BasketPage(driver, wait, action);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
