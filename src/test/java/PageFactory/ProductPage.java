package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.Console;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    By plus_btn=By.id("btn-increase-quantity");
    By minus_btn=By.id("btn-decrease-quantity");
    By amount_txtfield =By.id("quantity-input");
    By addToCart_btn=By.id("btn-add-to-cart");

    By gotoCart_btn =By.xpath("//a[@data-test='nav-cart' and @href='/checkout']");
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    public void TypeAmount(int number){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(amount_txtfield));
        amountField.clear();
        amountField.sendKeys(String.valueOf(number));
    }
    public void VarifyAmount(int number){
        Assert.assertEquals(driver.findElement(amount_txtfield).getAttribute("value"),String.valueOf(number));
    }
    public void VarifAddToCart(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(gotoCart_btn));
            Assert.assertTrue(cartBtn.isDisplayed(), "Cart button is not displayed after adding product to cart");
        //driver.findElement(gotoCart_btn).isDisplayed();
    }
    public  void ClickAddToCart(){
        driver.findElement(addToCart_btn).click();

    }

    public void ClickPlus(){
        driver.findElement(plus_btn).click();
    }
    public void ClickMinus(){
        driver.findElement(minus_btn).click();
    }
    public void GotoCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.toast-message")));

        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(gotoCart_btn));
        cartBtn.click();
        //driver.findElement(gotoCart_btn).click();


    }
    public void VarifyGotoCartPage(String redirector){
    // Assert.assertEquals(driver.getCurrentUrl(),redirector);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(redirector));
        Assert.assertEquals(driver.getCurrentUrl(), redirector);
    }
}
