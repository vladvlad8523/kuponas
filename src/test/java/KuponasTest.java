import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KuponasTest extends BaseTest {

    @Test
    void testKuponas() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Palm Treo Pro");
        driver.findElement(By.cssSelector(".btn.btn-light.btn-lg")).click();

        WebElement clickElement = driver.findElement(By.xpath("//h4/a[text()='Palm Treo Pro']"));
        //clickElement.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickElement); //func be skrolinimo paspaust

       WebElement addPalmTreoPro = driver.findElement(By.cssSelector("button#button-cart"));
       addPalmTreoPro.click();

        driver.findElement(By.cssSelector("button.btn-close")).click(); //uzdarom alert
        /**
         * funkcija puslapio scrolinimui i apacia
         */
    //        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");



        WebElement openCardShopping = driver.findElement(By.xpath("//a[@title='Shopping Cart']"));
        openCardShopping.click(); //apzvalga turimu prekiu
        Thread.sleep(3000);
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector("#accordion .accordion-item:nth-of-type(2) [data-bs-toggle]")).click();
        Thread.sleep(3000);
       WebElement inputCouponCode = driver.findElement(By.id("input-coupon"));
       inputCouponCode.sendKeys("1111");

       WebElement applyCoupon = driver.findElement(By.cssSelector("form#form-coupon  .btn.btn-primary"));
       executor.executeScript("arguments[0].click();", applyCoupon); //func be skrolinimo paspaust
        applyCoupon.click();

        Thread.sleep(3000);
        WebElement coupon = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(2) .text-end:nth-of-type(2)"));
        String name = coupon.getText();
        assertEquals("$-10.00", name);
        /**
         * tikrinam kaina
         */

        Thread.sleep(5000);
        WebElement couponPrice = driver.findElement(By.cssSelector(".table-responsive tbody tr .text-end:nth-of-type(6)"));
        String couponPriceTotal = couponPrice.getText();




        WebElement SubTotal = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(1) .text-end:nth-of-type(2)"));
        String couponSubTotal = SubTotal.getText();

        WebElement subCoupon = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(2) .text-end:nth-of-type(2)"));
        String couponSub = subCoupon.getText();

        WebElement EcoTax = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(3) .text-end:nth-of-type(2)"));
        String EcoTaxSub = EcoTax.getText();

        WebElement couponVAT = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(4) .text-end:nth-of-type(2)"));
        String sumCouponVAT = couponVAT.getText();

        String sumAll;
        sumAll = couponPriceTotal + couponSub + EcoTaxSub + sumCouponVAT;

        System.out.println(sumAll);

    }
}
