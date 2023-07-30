import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//Установка драйверов и закрытие браузера
public abstract class BaseTest {

    WebDriver driver;

    @Before
    public void setUp() {

        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}