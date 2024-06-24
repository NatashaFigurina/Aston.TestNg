import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("Тесты для веба")
@Feature("Тесты связанные с проверкой функционала фрейма BePaidFrame")
public class BePaidFrameTest {
    static WebDriver  driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PayWrapper pay = new PayWrapper(driver);

    @Step("Открытие страницы mts.by и отказ от сохранение cookies")
    public void openPage() {
        System.setProperty("web driver.chrome.driver", "./src/main/resources/selenium-chrome- driver-4.21.0");
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        PayWrapper pay = new PayWrapper(driver);
        try {
            driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
        } catch (Exception ignored) {
        }
    }

    @AfterTest
    public static void afterTest() {
        driver.quit();
    }

    @Step("Заполнение необходимых полей для открытия фрейма BePaidFrame")
    public void start() {
        pay.selectOption("Услуги связи");
        pay.fillInTheField();
        pay.clickButton();
        BePaidIFrame iFrame = pay.switchToBePaidFrame();
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка надписей в незаполненных полях фрейма")
    public void testCheckingTitleField() {
        openPage();
        start();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class ='ng-tns-c46-1 ng-star-inserted']"))).getText(),
                "Номер карты");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class ='ng-tns-c46-4 ng-star-inserted']"))).getText(),
                "Срок действия");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class ='ng-tns-c46-5 ng-star-inserted']"))).getText(),
                "CVC");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class ='ng-tns-c46-3 ng-star-inserted']"))).getText(),
                "Имя держателя (как на карте)");
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка наличия иконок платежных систем")
    public void testPayImages() {
        openPage();
        start();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class, 'ng-star-inserted')][1]"))).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class, 'ng-star-inserted')][2]"))).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class, 'ng-star-inserted')][3]"))).isEnabled());
    }

    @Owner(value = " Figurina Natasha")
    @Story("Позитивные тесты")
    @Test(description = "Проверка надписи суммы и номера телефона и суммы на кнопке")
    public void testCheckingTitleSum() {
        openPage();
        start();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='pay-description__cost']/span[1]"))).getText(), "10.00 BYN");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=pay-description__text]"))).getText(),
                "Оплата: Услуги связи Номер:375297777777");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'colored disabled']"))).getText(),
                "Оплатить 10.00 BYN");
    }
}



