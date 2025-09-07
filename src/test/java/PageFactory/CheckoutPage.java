package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
WebDriver driver;
    By quantity_txtField = By.xpath("//input[starts-with(@id,'quantity-')]");
By removeone_btn= By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/table/tbody/tr/td[5]/a");
By proceedCheckout_btn=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div");
By proceedCheckout_btn2=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div");
By proceedCheckout_btn3=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div");
By paymentmethod_combobox=By.id("payment-method");
public CheckoutPage(WebDriver driver){
    this.driver=driver;
}
public void TypeQuantity(int number){
   // driver.findElement(quantity_txtField).sendKeys(String.valueOf(number));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
           quantity_txtField
    ));
    quantityField.clear();
    quantityField.sendKeys(String.valueOf(number));
}
public void ClickRemoveone(){
     driver.findElement(removeone_btn).click();
}
public void ClickProceedCheckout(){
    driver.findElement(proceedCheckout_btn).click();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
//    WebElement proceedBtn = wait.until(
//            ExpectedConditions.elementToBeClickable(proceedCheckout_btn)
//    );
//    proceedBtn.click();
}
    public void ClickProceedCheckout_btn2(){
         driver.findElement(proceedCheckout_btn2).click();
    }
    public void ClickProceedCheckout_btn3(){
        driver.findElement(proceedCheckout_btn3).click();
    }

public void VarifyQuantitynum(int number){
    Assert.assertEquals(  driver.findElement(quantity_txtField).getAttribute("value"),String.valueOf(number));
}
public void VarifyClickedProceedCheckout(){
   driver.findElement(proceedCheckout_btn2).isDisplayed();
}
    public void VarifyClickedProceedCheckout_btn2(){
        driver.findElement(proceedCheckout_btn3).isDisplayed();
    }
    public void VarifyClickedProceedCheckout_btn3(){
        driver.findElement(paymentmethod_combobox).isDisplayed();
    }
}
