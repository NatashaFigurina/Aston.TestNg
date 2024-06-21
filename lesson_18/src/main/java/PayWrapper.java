import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Feature("Инициализация элементов и описание методов работы с главной страницей сайта mts.by")
public class PayWrapper {

    protected WebDriver driver;
    private By phone = By.xpath("//input[@placeholder='Номер телефона']");
    private By internet = By.xpath("//input[@placeholder='Номер абонента']");
    private By summ = By.xpath("//input[@id='connection-sum']");
    private By email = By.xpath("//input[@id='connection-email']");
    private By number44 = By.xpath("//input[@id='score-instalment']");
    private By number2073 = By.xpath("//input[@id='score-arrears']");
    private By selectOptionsButton= By.xpath("//button[@class='select__header']");
    private By submitButton = By.xpath("//form[@class='pay-form opened']//button[text()='Продолжить']");

    @Step("Запуск фрейма BePaidFrame")
    public BePaidIFrame switchToBePaidFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(By.className("bepaid-iframe")).isDisplayed());
        WebElement iframe = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(iframe);
        return new BePaidIFrame(driver.findElement(By.className("app-wrapper__content")));
    }

    @Step ("Выбор варианта услуги для оплаты онлайн")
    public void selectOption (String optionName){
        driver.findElement(selectOptionsButton).click();
        driver.findElement(By.xpath(String.format("//p[@class='select__option' and text()='%s']",optionName))).click();

    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА НОМЕРА ТЕЛЕФОНА")
    public String getPhonePlaceholder(){
        return driver.findElement(phone).getAttribute("placeholder");
    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА НОМЕРА АБАНЕНТА")
    public String getInternetPlaceholder(){
        return driver.findElement(internet).getAttribute("placeholder");
    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА СУММЫ ПОПОЛНЕНИЯ")
    public String getSummPlaceholder(){
        return driver.findElement(summ).getAttribute("placeholder");
    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА СУММЫ ПОПОЛНЕНИЯ ЭЛЕКТРОННОЙ ПОЧТЫ")
    public String getEmailPlaceholder(){
        return driver.findElement(email).getAttribute("placeholder");
    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА НОМЕРА СЧЕТА 44")
    public String getAccountNumber44 (){
        return driver.findElement(number44).getAttribute("placeholder");
    }

    @Step ("Получение атрибута плейсхолдер вебЭлемента СТРОКА ДЛЯ ВВОДА НОМЕРА СЧЕТА 2073")
    public String getAccountNumber2073 (){
        return driver.findElement(number2073).getAttribute("placeholder");
    }

    public PayWrapper(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Заполнение полей формы онлайн пополнения")
    public void fillInTheField() {
        driver.findElement(phone).sendKeys("297777777");
        driver.findElement(summ).sendKeys("10");
    }

    @Step("Нажатие на кнопку ПРОДОЛЖИТЬ")
    public void clickButton(){
        driver.findElement(submitButton).click();
    }
}
