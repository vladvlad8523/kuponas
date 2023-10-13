import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountLogin extends BaseTest {

    private final static String BASE_URL = ("http://192.168.11.6/administration/"); //konstanta



        @Test
        public void acountLogin () {
            driver.get(BASE_URL);
            /**
             * login in account
             */
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys("user");
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("OoPzB8PIWAnK");
            password.submit();

        }

}
