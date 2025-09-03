package PageTesting;

import PageFactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistreTest {
    WebDriver driver;
    ShoppingPage shoppingPage;
    CheckoutPage checkoutPage;
    ProductPage product;
    LoginPage loginPage;
    RegisterPage registerPage;
    PaymentPage paymentPage;
    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/auth/register");
        // driver.get("https://practicesoftwaretesting.com/auth/login");
        shoppingPage =new ShoppingPage(driver);
        product=new ProductPage(driver);
        checkoutPage=new CheckoutPage(driver);
        loginPage= new LoginPage(driver);
        registerPage=new RegisterPage(driver);
        paymentPage=new PaymentPage(driver);
    }
    @Test
    public void PositiveSenarioAddProduct(){
        registerPage.TypeFirstName("omarrr");
        registerPage.TypeLastName("elhadyy");
        registerPage.TypeDate("2000-12-12");
        registerPage.TypeStreet("Cairo");
        registerPage.TypeStreet("Croet");
        registerPage.TypePostalCode("1235");
        registerPage.TypeCity("CAomd");
        registerPage.TypeState("STss");
        registerPage.TypeCountry("EG");
        registerPage.Typephone("01145255412");
        registerPage.TypeEmail("elhayo@gmail.com");
        registerPage.TypePassword("O0m09695#0");
        registerPage.Click_Register_btn();
        registerPage.VarifyClickedRegister("https://practicesoftwaretesting.com/auth/login");
        loginPage.TypeEmail("elhayo@gmail.com");
        loginPage.VarifyEmail("elhayo@gmail.com");
        loginPage.TypePassword("O0m09695#0");
        loginPage.VarifyPassword("O0m09695#0");
        loginPage.Click_Loginbutton();
        loginPage.VarifyLoginDone("https://practicesoftwaretesting.com/account");
        loginPage.Click_HomePage();
        loginPage.VarifyClick_Home("https://practicesoftwaretesting.com/");

        shoppingPage.ClickAtProduct();
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/01K45BMRWX7E1RNGFK90KZQ7FV");
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
        checkoutPage.VarifyClickedProceedCheckout();
        checkoutPage.ClickProceedCheckout_btn2();
        checkoutPage.VarifyClickedProceedCheckout_btn2();
        checkoutPage.ClickProceedCheckout_btn3();
        checkoutPage.VarifyClickedProceedCheckout_btn3();
        paymentPage.SelectPaymentMethod("credit-card");
        paymentPage.TypeCreditCardNumber("0000-0000-0000-0000");
        paymentPage.TypeExpireDate("11/2030");
        paymentPage.TypeCVV("1235");
        paymentPage.TypeHolder("ELDfdfd");
        paymentPage.ClickConfirm();
        paymentPage.VarifyConfirm();

    }
    @AfterClass
    public void terminate(){
        driver.quit();
    }
}
