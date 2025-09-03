package PageTesting;

import PageFactory.CheckoutPage;
import PageFactory.LoginPage;
import PageFactory.ProductPage;
import PageFactory.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    ShoppingPage shoppingPage;
    CheckoutPage checkoutPage;
    ProductPage product;
    LoginPage loginPage;
    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        shoppingPage =new ShoppingPage(driver);
        product=new ProductPage(driver);
        checkoutPage=new CheckoutPage(driver);
        loginPage= new LoginPage(driver);
    }
    @Test
    public void PositiveSenarioAddProduct(){
        shoppingPage.ClickAtProduct();
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/01K44CQZN8HN4S6NC16DDFM1ES");
        product.TypeAmount(5);
        product.VarifyAmount(5);
        //product.ClickPlus();
        product.ClickMinus();
        product.ClickAddToCart();
        product.VarifAddToCart();
        product.GotoCart();
        product.VarifyGotoCartPage("https://practicesoftwaretesting.com/checkout");
        checkoutPage.TypeQuantity(9);
        //checkoutPage.ClickRemoveone();
        checkoutPage.VarifyQuantitynum(9);
        checkoutPage.ClickProceedCheckout();
        //checkoutPage.VarifyClickedProceedCheckout("https://practicesoftwaretesting.com/checkout");
        loginPage.TypeEmail("elhadyo424@gmail.com");
        loginPage.VarifyEmail("elhadyo424@gmail.com");
        loginPage.TypePassword("O0a19695#0");
        loginPage.VarifyPassword("O0a19695#0");
        loginPage.Click_Loginbutton();
        loginPage.VarifyLoginDone("https://practicesoftwaretesting.com/checkout");
        //loginPage.Click_ProceedCheckout();
        //loginPage.Click_ProceedCheckout();

        //loginPage.VarifyClick_ProceedCheckout("https://practicesoftwaretesting.com/checkout");

    }
    @AfterClass
    public void terminate(){
        //driver.quit();
    }
}
