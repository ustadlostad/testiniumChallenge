package pages;

import com.batur.testiniumchallenge.PageSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailPage extends PageSetup {
    public ItemDetailPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }

    //Page Objects
    String item_name_xpath = "//div[@class = 'pr-in-cn']//h1";
    String item_price_xpath = "(//div[@class = 'product-price-container']//span)[last()]";
    String add_to_basket_button_xpath = "//button[@class = 'add-to-basket']";
    String my_basket_button_xpath = "(//p[text() = \"Sepetim\"])[1]";

    By item_name = By.xpath(item_name_xpath);
    By item_price = By.xpath(item_price_xpath);
    By add_to_basket_button = By.xpath(add_to_basket_button_xpath);
    By my_basket_button = By.xpath(my_basket_button_xpath);

    //Page Methods
    public String getItemName(){
        return getText(item_name);
    }

    public String getItemPrice(){
        return getText(item_price);
    }

    public void switchBrowserTab() {
        switchTab();
    }

    public void addItemToTheBasket() {
        click(add_to_basket_button);
    }

    public void goToBasket() {
        click(my_basket_button);
    }

}
