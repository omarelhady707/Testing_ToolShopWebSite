package PageTesting;

import PageFactory.CheckoutPage;
import PageFactory.ProductPage;
import PageFactory.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    WebDriver driver;
    ShoppingPage shoppingPage;
    CheckoutPage checkoutPage;
    ProductPage product;
    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        shoppingPage =new ShoppingPage(driver);
        product=new ProductPage(driver);
        checkoutPage=new CheckoutPage(driver);
    }
    @Test
    public void PositiveSenarioAddProduct(){
        shoppingPage.ClickAtProduct();
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/01K449A44ES4HC703BN44GGE3N");
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
        checkoutPage.VarifyClickedProceedCheckout("https://practicesoftwaretesting.com/checkout");
    }
    @AfterClass
    public void terminate(){
        //driver.quit();
    }
}
