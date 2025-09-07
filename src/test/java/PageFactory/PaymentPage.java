package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    WebDriver driver;
    By paymentmethod_combobox=By.xpath("//*[@id=\"payment-method\"]");
    By creditcard_textfield= By.id("credit_card_number");
    By expirataiondate_textfield=By.id("expiration_date");
    By cvv_textfield= By.id("cvv");
    By placeholder_txtfield=By.id("card_holder_name");
    By confirm_btn=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div");
    By confirm2_btn=By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div");

    public PaymentPage(WebDriver driver){
        this.driver=driver;
    }
    public void SelectPaymentMethod(String value){
        Select select=new Select(driver.findElement(paymentmethod_combobox));
        select.selectByValue(value);
    }
    public void TypeCreditCardNumber(String number){
    driver.findElement(creditcard_textfield).sendKeys(number);
    }
    public void TypeExpireDate(String date){
        driver.findElement(expirataiondate_textfield).sendKeys(date);
    }
    public void TypeCVV(String cvv){
        driver.findElement(cvv_textfield).sendKeys(cvv);

    }
    public void TypeHolder(String holdername){
        driver.findElement(placeholder_txtfield).sendKeys(holdername);
    }
    public void ClickConfirm(){
        driver.findElement(confirm_btn).click();
    }
    public void VarifyConfirm(){
        driver.findElement(confirm2_btn).isDisplayed();
    }
}
