package pages;

import com.batur.testiniumchallenge.PageSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageSetup {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Elements
    String email_textBox_id = "login-email";
    String password_textBox_id = "login-password-input";
    String login_button_xpath = "//button[@type=\"submit\"]";
    String my_account_label_xpath = "//div[@id='account-navigation-container']//p[text()='Hesabım']";
    String home_page_wrapper_id = "browsing-gw-homepage";

    By email_textBox = By.id(email_textBox_id);
    By password_textBox = By.id(password_textBox_id);
    By login_button = By.xpath(login_button_xpath);
    By home_page_wrapper = By.id(home_page_wrapper_id);
    By my_account_label = By.xpath(my_account_label_xpath);

    //Page Methods
    public void setEmail(String email){
        setText(email,email_textBox);
    }

    public void setPassword(String password){
        setText(password,password_textBox);
    }

    public void clickLoginButton(){
        click(login_button);
    }

    public void checkLoginStatus(){
        checkDisplay(my_account_label);
    }

    public void checkMainPage(){
        checkDisplay(home_page_wrapper);
    }
}
