import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

@Epic("Тесты для веба")
@Feature("Тесты связанные с проверкой функционала блока Онлайн пополнения на сайте mts.by")
public class PayWrapperTest {

    public static WebDriver driver = new ChromeDriver();
    PayWrapper pay = PageFactory.initElements(driver, PayWrapper.class);

    @Step("Открытие страницы")
    @BeforeClass
    public static void openPage() {
        System.setProperty("web driver.chrome.driver", "./src/main/resources/selenium-chrome- driver-4.21.0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        try {
            driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
        } catch (Exception ignored) {
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@class = 'pay__wrapper']")));
    }

    @AfterTest
    public static void afterTest() {
        driver.quit();
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка надписей в полях УСЛУГИ СВЯЗИ")
    public void testCheckConnectionOption() {
        pay.selectOption("Услуги связи");
        Assert.assertEquals(pay.getPhonePlaceholder(), "Номер телефона");
        Assert.assertEquals(pay.getSummPlaceholder(), "Сумма");
        Assert.assertEquals(pay.getEmailPlaceholder(), "E-mail для отправки чека");
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка надписей в полях ДОМАШНИЙ ИНТЕРНЕТ")
    public void testCheckInternetOption() {
        pay.selectOption("Домашний интернет");
        Assert.assertEquals(pay.getInternetPlaceholder(), "Номер абонента");
        Assert.assertEquals(pay.getSummPlaceholder(), "Сумма");
        Assert.assertEquals(pay.getEmailPlaceholder(), "E-mail для отправки чека");
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка уникальных надписей в полях РАССРОЧКА")
    public void testCheckInstallmentOption() {
        pay.selectOption("Рассрочка");
        Assert.assertEquals(pay.getAccountNumber44(), "Номер счета на 44");
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка уникальных надписей в полях Задолжность")
    public void testCheckDeptOption() {
        pay.selectOption("Задолженность");
        Assert.assertEquals(pay.getAccountNumber2073(), "Номер счета на 2073");
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка работы кнопки ПРОДОЛЖИТЬ ")
    public void testClickButton() {
        pay.selectOption("Услуги связи");
        pay.fillInTheField();
        pay.clickButton();
        Assert.assertTrue(driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']")).isEnabled());
    }
}