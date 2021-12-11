package tests;

import com.batur.testiniumchallenge.TestSetup;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.io.IOException;


public class Tests extends TestSetup {
    Utils utils = new Utils();

    String itemDetailPageName;
    String itemDetailPagePrice;
    String itemBasketName;
    String itemBasketPrice;

    @Test(priority = 1)
    public void login() throws IOException, CsvException, InterruptedException {
        landingPage.navigate("https://www.trendyol.com");
        landingPage.closePopupWindow();
        landingPage.clickLoginButton();
        loginPage.setEmail(utils.readCsv(0, 0));
        loginPage.setPassword(utils.readCsv(0, 1));
        loginPage.clickLoginButton();
        loginPage.checkLoginStatus("Baturtestmaili@Gmail.Com");
        loginPage.checkMainPage();
    }

    @Test(priority = 2)
    public void addItemToBasket() throws IOException{
        mainPage.searchAnItem("Bilgisayar");
        listPage.selectRandomItem();
        itemDetailPage.switchBrowserTab();
        itemDetailPageName = itemDetailPage.getItemName();
        itemDetailPagePrice = itemDetailPage.getItemPrice();
        utils.writeTxt(itemDetailPageName);
        utils.writeTxt(itemDetailPagePrice);
        itemDetailPage.addItemToTheBasket();
        itemDetailPage.goToBasket();
    }

    @Test(priority = 3)
    public void compareItemDetails(){
        itemBasketName = basketPage.getItemBasketName();
        itemBasketPrice = basketPage.getItemBasketPrice();
        Assert.assertTrue(itemBasketPrice.contains(itemDetailPagePrice));
        Assert.assertTrue(itemDetailPageName.contains(itemBasketName));
    }

    @Test(priority = 4)
    public void increaseAndCheckItemCount() throws InterruptedException {
        Assert.assertEquals(basketPage.increaseItemCountAndGetItemCount(),"2");
    }

    @Test(priority = 5)
    public void deleteItemFromBasketAndCheck(){
        Assert.assertEquals(basketPage.deleteItemFromBasket(),"Sepetinde ürün bulunmamaktadır.");
    }
}
