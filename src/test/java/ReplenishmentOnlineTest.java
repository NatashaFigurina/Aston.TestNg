import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ReplenishmentOnlineTest {

    @BeforeClass

    public static void setup() {
        System.setProperty("web driver.chrome.driver", "/home/natasha/IdeaProjects/Aston.TestNg/src/main/resources/selenium-chrome- driver-4.21.0");
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
    }

    @AfterTest
    public static void afterTest() {
        driver.quit();
    }

    public static WebDriver driver = new ChromeDriver();


    ReplenishmentOnline replenishmentOnline = PageFactory.initElements(driver, ReplenishmentOnline.class);

    @Test(description = "Проверка имени блока")

    public void testBlockNameCheck() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(replenishmentOnline.getBlockName(), expectedTitle);
    }

    @Test(description = "Проверка наличия логотипов платежных систем")

    public void testPaymentLogosCheck() {
        Assert.assertTrue(replenishmentOnline.logoCheck());
    }

    @Test(description = "Проверка работы ссылки ПОДРОБНЕЕ О СЕРВИСЕ")

    public void testCheckingLinkFunctionality() {
        replenishmentOnline.clickLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test(description = "Проверка работы кнопки ПРОДОЛЖИТЬ с заполненными полями ТЕЛЕФОН и СУММА")

    public void testCheckingTheButtonOperation() {
        replenishmentOnline.selectingValueFromDropdown();
        replenishmentOnline.fillInTheField();
        replenishmentOnline.pressButton();
    }
}
