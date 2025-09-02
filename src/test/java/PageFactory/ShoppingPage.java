package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingPage {
    WebDriver driver;
    By product_btn = By.xpath("//a[@data-test='product-01K42171PCDFDWA5O5X8BP7Z08']");
    public ShoppingPage(WebDriver driver){
        this.driver=driver;
    }
    public void ClickAtProduct(){
       // driver.findElement(product_btn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//h5[normalize-space()='Combination Pliers']/ancestor::a")));
        product.click();

    }
    public void VarifyProductIsClicked(String redirector){
        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }

}
