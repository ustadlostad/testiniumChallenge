package pages;

import com.batur.testiniumchallenge.PageSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends PageSetup {

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    //Page Elements
    String email_textBox_id = "login-email";
    String password_textBox_id = "login-password-input";
    String login_button_xpath = "//button[@type=\"submit\"]";
    String my_account_label_xpath = "//p[contains(text(),'Hesabım')]";
    String home_page_wrapper_id = "browsing-gw-homepage";
    String mail_label_xpath = "//div[@class = 'user-loggedin-container']//p[@class = 'user-name']";

    By email_textBox = By.id(email_textBox_id);
    By password_textBox = By.id(password_textBox_id);
    By login_button = By.xpath(login_button_xpath);
    By home_page_wrapper = By.id(home_page_wrapper_id);
    By my_account_label = By.xpath(my_account_label_xpath);
    By mail_label = By.xpath(mail_label_xpath);

    //Page Methods
    public void setEmail(String email) {
        setText(email, email_textBox);
    }

    public void setPassword(String password) {
        setText(password, password_textBox);
    }

    public void clickLoginButton() {
        click(login_button);
    }

    public void checkLoginStatus(String email) throws InterruptedException {
        hover(my_account_label);
        Assert.assertEquals(getText(mail_label), email);
    }

    public void checkMainPage() {
        checkElementIsVisible(home_page_wrapper);
    }
}
