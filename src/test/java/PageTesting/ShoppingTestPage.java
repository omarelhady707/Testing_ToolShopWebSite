package PageTesting;

import PageFactory.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ShoppingTestPage {
    WebDriver driver;
    ShoppingPage shoppingPage;
    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//IdeaProjects//gym_management_system-main//TestingMaharaTech//src//test//java//PageSources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        shoppingPage =new ShoppingPage(driver);
    }
    @Test
    public void PositiveSenarioShoppingPage(){
       // shoppingPage.ClickAtProduct();
        shoppingPage.VarifyProductIsClicked("https://practicesoftwaretesting.com/product/01K4282QMBQHFW963HTDYY9QNA");
    }
    @AfterClass
    public void terminate(){
        driver.quit();
    }

}
