/**
 * inicilizacija Webdriver
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {


        private final static String BASE_URL = ("http://192.168.11.6"); //konstanta

        public WebDriver driver;


        @BeforeEach
        public void init () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(BASE_URL); //atidarom tinklalapi
            driver.manage().window().maximize(); //narsikles langas max
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //laukiam kol puslapis pilnai neuzsikraus. 10 sekundziu
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //laukiam kol pasikraus visi elementai

        }
        @AfterEach
        public void tearDown () {
        driver.close(); //uzdarim wwebdriver kad nevykdytu procesu
        driver.quit();  //uzdarom langa po testo
        }

}
