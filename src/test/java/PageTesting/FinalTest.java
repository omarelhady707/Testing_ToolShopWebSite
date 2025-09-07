package PageTesting;

import PageFactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FinalTest {
    WebDriver driver;
    ShoppingPage shoppingPage;
    CheckoutPage checkoutPage;
    ProductPage product;
    LoginPage loginPage;
    RegisterPage registerPage;
    PaymentPage paymentPage;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        shoppingPage = new ShoppingPage(driver);
        product = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    // --- DataProvider ---
    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() {
        return new Object[][]{
                {"Omarr", "Elhady", "2000-12-12", "Street1", "Street2", "12345", "Cairo", "CairoState", "EG", "0111111111", "omawer@teest.com", "Pass1231223#",
                        "01K4J0RQFWC093DY3XCMPAPNYR", 3, // Product ID + quantity
                        "credit-card", "1111-2222-3333-4444", "11/2030", "123", "Omar Card"},

                {"Ali", "Mostafa", "1998-05-10", "StreetX", "StreetY", "54321", "Alex", "AlexState", "EG", "0122222222", "awlqi@teest.com", "AliPass#123323",
                        "01K4J0RQFWC093DY3XCMPAPNYR", 2,
                        "credit-card", "5555-6666-7777-8888", "10/2029", "456", "Ali Holder"}
        };
    }

    @Test(dataProvider = "checkoutData")
    public void PositiveScenarioAddProduct(
            String firstName, String lastName, String dob, String street1, String street2,
            String postalCode, String city, String state, String country, String phone,
            String email, String password, String productId, int qty,
            String paymentMethod, String cardNum, String expDate, String cvv, String holder
    ) {
        // 1. Register
        driver.get("https://practicesoftwaretesting.com/auth/register");
        registerPage.TypeFirstName(firstName);
        registerPage.TypeLastName(lastName);
        registerPage.TypeDate(dob);
        registerPage.TypeStreet(street1);
        registerPage.TypeStreet(street2);
        registerPage.TypePostalCode(postalCode);
        registerPage.TypeCity(city);
        registerPage.TypeState(state);
        registerPage.TypeCountry(country);
        registerPage.Typephone(phone);
        registerPage.TypeEmail(email);
        registerPage.TypePassword(password);
        registerPage.Click_Register_btn();
        registerPage.VarifyClickedRegister("https://practicesoftwaretesting.com/auth/login");

        // 2. Login
        loginPage.TypeEmail(email);
        loginPage.VarifyEmail(email);
        loginPage.TypePassword(password);
        loginPage.VarifyPassword(password);
        loginPage.Click_Loginbutton();
        loginPage.VarifyLoginDone("https://practicesoftwaretesting.com/account");
        loginPage.Click_HomePage();
        loginPage.VarifyClick_Home("https://practicesoftwaretesting.com/");

        // 3. Select Product
        shoppingPage.ClickAtProduct(); // ممكن تعملها ديناميك بالproductId لو حابب
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/" + productId);
        product.TypeAmount(qty);
        product.VarifyAmount(qty);
        product.ClickAddToCart();
        product.VarifAddToCart();
        product.GotoCart();
        product.VarifyGotoCartPage("https://practicesoftwaretesting.com/checkout");

        // 4. Checkout
        checkoutPage.TypeQuantity(qty);
        checkoutPage.VarifyQuantitynum(qty);
        checkoutPage.ClickProceedCheckout();
        checkoutPage.VarifyClickedProceedCheckout();
        checkoutPage.ClickProceedCheckout_btn2();
        checkoutPage.VarifyClickedProceedCheckout_btn2();
        checkoutPage.ClickProceedCheckout_btn3();
        checkoutPage.VarifyClickedProceedCheckout_btn3();

        // 5. Payment
        paymentPage.SelectPaymentMethod(paymentMethod);
        paymentPage.TypeCreditCardNumber(cardNum);
        paymentPage.TypeExpireDate(expDate);
        paymentPage.TypeCVV(cvv);
        paymentPage.TypeHolder(holder);
        paymentPage.ClickConfirm();
        paymentPage.VarifyConfirm();
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }
}
