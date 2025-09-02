package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    By email_txtfield= By.id("email");
    By password_txtfield=By.id("password");
    By login_btn = By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/form/div[3]/input");
   By proceedCheckout_btn=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void TypeEmail(String email){
        driver.findElement(email_txtfield).sendKeys(email);
    }
    public void TypePassword(String password){
        driver.findElement(password_txtfield).sendKeys(password);
    }
    public void VarifyEmail(String email){
        Assert.assertEquals(driver.findElement(email_txtfield).getAttribute("value"),email);
    }
    public void VarifyPassword(String password){
        Assert.assertEquals(driver.findElement(password_txtfield).getAttribute("value"),password);
    }
    public void Click_Loginbutton(){
        driver.findElement(login_btn).click();
    }
    public void  VarifyLoginDone(String redirector){

        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }
    public void Click_ProceedCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // استنى لحد ما الزر يبقى ظاهر في الصفحة
        WebElement proceedBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(proceedCheckout_btn)
        );

        // بعد ما بقى ظاهر، استنى كمان يبقى clickable
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));

        // اضغط على الزر
        proceedBtn.click();
        System.out.println("Button is Clicked");

        //driver.findElement(proceedCheckout_btn).click();
    }
    public void  VarifyClick_ProceedCheckout(String redirector){
        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }

}
