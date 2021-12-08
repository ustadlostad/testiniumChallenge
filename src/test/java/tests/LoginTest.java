package tests;

import com.batur.testiniumchallenge.TestSetup;
import com.opencsv.exceptions.CsvException;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;


public class LoginTest extends TestSetup {
    Utils utils = new Utils();

    @Test
    public void login() throws IOException, CsvException {
        landingPage.navigate("https://www.trendyol.com");
        landingPage.closePopupWindow();
        landingPage.clickLoginButton();
        loginPage.setEmail(utils.readCsv(0,0));
        loginPage.setPassword(utils.readCsv(0,1));
        loginPage.clickLoginButton();
        loginPage.checkLoginStatus();
        loginPage.checkMainPage();
    }
}
