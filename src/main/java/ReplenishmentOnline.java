import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class ReplenishmentOnline {
    protected WebDriver driver;

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

    @FindBy(xpath = "//button[@class='select__header']")
    WebElement dropDownText;

    @FindBy(xpath = "//form[@class='pay-form opened']//button[text()='Продолжить']")
    WebElement button;

    public ReplenishmentOnline(WebDriver driver) {
        this.driver = driver;
    }

    public String getBlockName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}


