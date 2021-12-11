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
    String plus_button_xpath = "//button[@class = 'ty-numeric-counter-button']";
    String counter_content_xpath = "//input[@class = 'counter-content']";
    String trash_icon_xpath = "//i[@class = 'i-trash']";
    String delete_button_xpath = "//button[text()='Sil']";
    String basket_empty_label_xpath = "//div[@class='pb-empty-basket']//span";

    By item_name = By.xpath(item_name_xpath);
    By item_basket_price = By.xpath(item_basket_price_xpath);
    By plus_button = By.xpath(plus_button_xpath);
    By counter_content = By.xpath(counter_content_xpath);
    By trash_icon = By.xpath(trash_icon_xpath);
    By delete_button = By.xpath(delete_button_xpath);
    By basket_empty_label = By.xpath(basket_empty_label_xpath);

    //Page Methods
    public String getItemBasketName(){
        return getAttribute(item_name,"title");
    }

    public String getItemBasketPrice(){
        return getAttribute(item_basket_price,"textContent");
    }

    public String increaseItemCountAndGetItemCount() throws InterruptedException {
        click(plus_button);
        Thread.sleep(1000);
        return getAttribute(counter_content,"value");
    }

    public String deleteItemFromBasket(){
        click(trash_icon);
        click(delete_button);
        return getText(basket_empty_label);
    }


}
