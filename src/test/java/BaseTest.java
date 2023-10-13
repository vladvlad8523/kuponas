import com.github.dockerjava.api.model.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.Configuration;
import java.time.Duration;

public class BaseTest {


        private final static String BASE_URL = ("http://192.168.11.6"); //konstanta

        public WebDriver driver;


        @BeforeEach
        public void init () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(BASE_URL); //atidarom tinklalapi
            //JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @AfterEach
        public void tearDown () {
        driver.quit();
        }

}
