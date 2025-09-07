package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver    ;
    By firstName_txtfield= By.id("first_name");
    By lastName_txtfield= By.id("last_name");
    By date_txtfield= By.id("dob");
    By street_txtfield= By.id("street");
    By postalCode_txtfield= By.id("postal_code");
    By city_txtfield= By.id("city");
    By state_txtfield= By.id("state");
    By country_txtfield=By.id("country");
    By phone_txtfield= By.id("phone");
    By email_txtfield= By.id("email");
    By password_txtfield= By.id("password");
    By register_btn =By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button");
    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }
    public void TypeFirstName(String firstname){
        driver.findElement(firstName_txtfield).sendKeys(firstname);
    }
    public void TypeLastName(String lastname){
        driver.findElement(lastName_txtfield).sendKeys(lastname);
    }  public void TypeDate(String date){
        driver.findElement(date_txtfield).sendKeys(date);
    }  public void TypeStreet(String street){
        driver.findElement(street_txtfield).sendKeys(street);
    }  public void TypePostalCode(String PostalCode){
        driver.findElement(postalCode_txtfield).sendKeys(PostalCode);
    }  public void TypeCity(String city){
        driver.findElement(city_txtfield).sendKeys(city);
    }  public void TypeState(String state){
        driver.findElement(state_txtfield).sendKeys(state);
    }  public void TypeCountry(String country){
        Select select=new Select(driver.findElement(country_txtfield));
        select.selectByValue(country);
    }  public void TypeEmail(String email){
        driver.findElement(email_txtfield).sendKeys(email);
    }  public void TypePassword(String password){
        driver.findElement(password_txtfield).sendKeys(password);
    }
    public void Typephone(String number){
        driver.findElement(phone_txtfield).sendKeys(number);
    }
    public void Click_Register_btn(){
        driver.findElement(register_btn).click();
    }
    public void VarifyClickedRegister(String redirector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // استنى لحد ما الـ URL يبقى هو المطلوب
        wait.until(ExpectedConditions.urlToBe(redirector));

        Assert.assertEquals(driver.getCurrentUrl(),redirector);
    }


}
