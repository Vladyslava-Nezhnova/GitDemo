import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class firstClass {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "/Users/vladislava/QA/webdrivers/chromedriver");//задаем путь к драйверу
        WebDriver driver = new ChromeDriver(options);// создаем драйвер

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// устанавливаем неявные ожидания

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// создаем экемпляр для явных ожиданий

        //JavascriptExecutor js = (JavascriptExecutor)driver;

        try {

            driver.get("");
            Thread.sleep(5000);
        LoginPage lp = new LoginPage();
        lp.login("admin", "admin");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
