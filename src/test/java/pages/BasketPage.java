package pages;

import com.batur.testiniumchallenge.PageSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends PageSetup {

    public BasketPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);

    }

    //Page Objects
    String item_name_xpath = "//p[@class = \"pb-item\"]";
    String item_basket_price_xpath = "//div[@class = \"pb-basket-item-price\"]";

    By item_name = By.xpath(item_name_xpath);
    By item_basket_price = By.xpath(item_basket_price_xpath);

    //Page Methods
    public String getItemBasketName() throws InterruptedException {
        return getAttribute(item_name,"title");
    }

    public String getItemBasketPrice() throws InterruptedException {
        return getText(item_basket_price);
    }

}
