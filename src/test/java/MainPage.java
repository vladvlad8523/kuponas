import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage{

    WebDriver driver;
    By shopingCartButton = By.cssSelector("div:nth-of-type(2) > form[method='post']  .button-group > button:nth-of-type(1)");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickShopingButton() {
        driver.findElement(shopingCartButton).click();
    }
}
