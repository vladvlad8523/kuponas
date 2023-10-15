import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KuponasTest extends BaseTest {
    //@RepeatedTest(3)
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

        WebElement openCardShopping = driver.findElement(By.xpath("//a[@title='Shopping Cart']"));
        openCardShopping.click(); //apzvalga turimu prekiu
        //Thread.sleep(3000);
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector("#accordion .accordion-item:nth-of-type(2) [data-bs-toggle]")).click();
        //Thread.sleep(3000);
       WebElement inputCouponCode = driver.findElement(By.id("input-coupon"));
       inputCouponCode.sendKeys("1111");

       WebElement applyCoupon = driver.findElement(By.cssSelector("form#form-coupon  .btn.btn-primary"));
       executor.executeScript("arguments[0].click();", applyCoupon); //func be skrolinimo paspaust
       applyCoupon.submit();

        Thread.sleep(3000);
        WebElement coupon = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(2) .text-end:nth-of-type(2)"));
        String name = coupon.getText();
        assertEquals("$-10.00", name);
        /**
         * tikrinam kaina
         */
        @Deprecated(since = "ieskomas bendra suma paliginimui")
        //Thread.sleep(5000);
        WebElement couponPrice = driver.findElement(By.cssSelector(".table-responsive tbody tr .text-end:nth-of-type(6)"));
        String couponPriceTotal = couponPrice.getText();
        String s = couponPriceTotal;
        s = s.substring(1).replace("$", " ");
        double numberCouponPriceTotal = Double.parseDouble(s);





        WebElement SubTotal = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(1) .text-end:nth-of-type(2)"));
        String couponSubTotal = SubTotal.getText();
        String b = couponSubTotal;
        b = b.substring(1).replace("$", " ");
        double numberCouponSubTotal = Double.parseDouble(b);



        WebElement subCoupon = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(2) .text-end:nth-of-type(2)"));
        String couponSub = subCoupon.getText();
        String c = couponSub;
        c = c.substring(1).replace("$", " ");
        double numberCouponSub = Double.parseDouble(c);


        WebElement EcoTax = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(3) .text-end:nth-of-type(2)"));
        String EcoTaxSub = EcoTax.getText();
        String a = EcoTaxSub;
        a = a.substring(1).replace("$", " ");
        double numberEcoTaxSub = Double.parseDouble(a);


        WebElement couponVAT = driver.findElement(By.cssSelector("#checkout-total tr:nth-of-type(4) .text-end:nth-of-type(2)"));
        String sumCouponVAT = couponVAT.getText();
        String z = sumCouponVAT;
        z = z.substring(1).replace("$", " ");
        double numberSumCouponVAT = Double.parseDouble(z);

        double resultSum = numberCouponPriceTotal + numberCouponSub + numberEcoTaxSub + numberSumCouponVAT;
        System.out.println(resultSum);

    }
}
