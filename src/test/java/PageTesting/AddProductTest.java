package PageTesting;

import PageFactory.ProductPage;
import PageFactory.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {
    WebDriver driver;
    ShoppingPage shoppingPage;
    ProductPage product;
    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        shoppingPage =new ShoppingPage(driver);
        product=new ProductPage(driver);
    }
    @Test
    public void PositiveSenarioAddProduct(){
        shoppingPage.ClickAtProduct();
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/01K42S81CG8VQ07N4EW2RWY6XK");
        product.TypeAmount(5);
        product.VarifyAmount(5);
        //product.ClickPlus();
        product.ClickMinus();
        product.ClickAddToCart();
        product.VarifAddToCart();
        product.GotoCart();
        product.VarifyGotoCartPage("https://practicesoftwaretesting.com/checkout");
    }
    @AfterClass
    public void terminate(){
        //driver.quit();
    }
}
