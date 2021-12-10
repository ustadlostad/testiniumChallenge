package pages;

import com.batur.testiniumchallenge.PageSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageSetup {

    public MainPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    //Page Elements
    String search_bar_xpath = "//input[@class = 'search-box']";

    By search_bar = By.xpath(search_bar_xpath   );

    //Page Methods
    public void searchAnItem(String item){
        setText(item,search_bar);
        pressEnter(search_bar);
    }





}
