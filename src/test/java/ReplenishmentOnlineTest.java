import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ReplenishmentOnlineTest {

    public static WebDriver driver = new ChromeDriver();
    ReplenishmentOnline replenishmentOnline = PageFactory.initElements(driver, ReplenishmentOnline.class);

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }

    @Test(description = "Проверка имени блока")
    public void testBlockNameCheck() {
        replenishmentOnline.openPage();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(replenishmentOnline.getBlockName(), expectedTitle);
    }

    @Test(description = "Проверка наличия логотипов платежных систем")
    public void testPaymentLogosCheck() {
        replenishmentOnline.openPage();
        Assert.assertFalse(replenishmentOnline.logoCheck());
    }

    @Test(description = "Проверка работы ссылки ПОДРОБНЕЕ О СЕРВИСЕ")
    public void testCheckingLinkFunctionality() {
        replenishmentOnline.openPage();
        replenishmentOnline.clickLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test(description = "Проверка работы кнопки ПРОДОЛЖИТЬ с заполненными полями ТЕЛЕФОН и СУММА")
    public void testCheckingTheButtonOperation() {
        replenishmentOnline.openPage();
        replenishmentOnline.selectingValueFromDropdown();
        replenishmentOnline.fillInTheField();
        replenishmentOnline.pressButton();
    }
}