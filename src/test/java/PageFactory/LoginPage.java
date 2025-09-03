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
    By login_btn = By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input");
   By home_lnk=By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a");
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // استنى لحد ما الـ URL يبقى هو المطلوب
        wait.until(ExpectedConditions.urlToBe(redirector));

        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }
    public void Click_HomePage(){
    driver.findElement(home_lnk).click();
    }
    public void  VarifyClick_Home(String redirector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // استنى لحد ما الـ URL يبقى هو المطلوب
        wait.until(ExpectedConditions.urlToBe(redirector));


        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }

}
