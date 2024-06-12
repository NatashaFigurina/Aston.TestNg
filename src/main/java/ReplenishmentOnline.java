import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class ReplenishmentOnline {

    public static WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//button[@class='select__header']")
    WebElement dropDownText;

    @FindBy(xpath = "//form[@class='pay-form opened']//button[text()='Продолжить']")
    WebElement button;

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> payment_logos;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement infoLink;

    @FindBy(xpath = "//*[@id='connection-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='connection-sum']")
    private WebElement summaField;

    public ReplenishmentOnline(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "src/driver/selenium-chrome-driver-4.21.0");
        ReplenishmentOnline.driver = driver;
    }

    public String getBlockName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));
        return blockTitle.getText();
    }

    public void pressButton() {
        button.click();
    }

    public void clickLink() {
        infoLink.click();
    }


    public void fillInTheField() {
        phoneField.sendKeys("297777777");
        summaField.sendKeys("10");
    }

    public boolean logoCheck() {
        return payment_logos.isEmpty();
    }

    public void selectingValueFromDropdown() {
        dropDownText.click();

    }

    public void openPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        try {
            driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
        }
        catch (Exception ignored){}
    }
}


