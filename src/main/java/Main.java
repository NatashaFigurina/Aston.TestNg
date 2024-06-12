import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ready to launch the browser");
        System.setProperty("web driver.chrome.driver", "/home/natasha/IdeaProjects/selenium-prodject-mts/src/main/resources/selenium-chrome- driver-4.21.0");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }
}
