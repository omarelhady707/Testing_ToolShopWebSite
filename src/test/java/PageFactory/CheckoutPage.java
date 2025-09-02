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
   // driver.findElement(proceedCheckout_btn).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    WebElement proceedBtn = wait.until(
            ExpectedConditions.elementToBeClickable(proceedCheckout_btn)
    );
    proceedBtn.click();
}
public void VarifyQuantitynum(int number){
    Assert.assertEquals(  driver.findElement(quantity_txtField).getAttribute("value"),String.valueOf(number));
}
public void VarifyClickedProceedCheckout(String redirector){
    Assert.assertEquals(driver.getCurrentUrl(),redirector);
}
}
