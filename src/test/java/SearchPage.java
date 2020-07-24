import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BaseTest {
    @Test(priority = 4)
    @Story("Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase4() throws InterruptedException, IOException {
        try {
            driver.get(n11_Url);
            driver.findElement(By.className(btnClose)).click();
            driver.findElement(By.className(btnSignIn)).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath(btnFacebook)).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            for (String handle : tabs) {
                System.out.println(handle);
            }
            //Switch to the last tab
            driver.switchTo().window(tabs.get(1));

            driver.findElement(By.id(email)).sendKeys(fbEmail);
            driver.findElement(By.id(pass)).sendKeys(myPassword);
            WebElement lgnBtn = driver.findElement(By.xpath(loginBtn));
            if (lgnBtn.isDisplayed() && lgnBtn.isEnabled()) {
                lgnBtn.click();
                Log4j.info("Login is successful!");
            } else {
                Log4j.info("Login is failed!");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().window(tabs.get(0));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.id(searchData)).sendKeys("samsung");
            driver.findElement(By.className(searchBtn)).click();
            Log4j.info("Searched samsung");
            testPassedResult("Test Case 4 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 4 : ");
            Log4j.warning("Test Case 4 Failed!");
        }
    }

    @Test(priority = 5)
    @Story("Gelen sayfada samsung icin sonuc bulundugunu onaylayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase5() throws IOException {
        try {
            driver.get(n11_Url);
            driver.findElement(By.className(btnClose)).click();
            driver.findElement(By.className(btnSignIn)).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath(btnFacebook)).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            for (String handle : tabs) {
                System.out.println(handle);
            }
            //Switch to the last tab
            driver.switchTo().window(tabs.get(1));

            driver.findElement(By.id(email)).sendKeys(fbEmail);
            driver.findElement(By.id(pass)).sendKeys(myPassword);
            WebElement lgnBtn = driver.findElement(By.xpath(loginBtn));
            if (lgnBtn.isDisplayed() && lgnBtn.isEnabled()) {
                lgnBtn.click();
                Log4j.info("Login is successful!");
            } else {
                Log4j.info("Login is failed!");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().window(tabs.get(0));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.id(searchData)).sendKeys("samsung");
            driver.findElement(By.className(searchBtn)).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement result = driver.findElement(By.className(resultText));
            Assert.assertTrue(result.getText().contains("Samsung"));
            Assert.assertTrue(result.getText().contains("sonuç bulundu."));
            Log4j.info("Results found about samsung!");
            testPassedResult("Test Case 5 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 5 : ");
            Log4j.warning("Test Case 5 Failed!");
        }
    }

    @Test(priority = 6)
    @Story("Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase6() throws IOException {
        try {
            driver.get(n11_Url);
            driver.findElement(By.className(btnClose)).click();
            driver.findElement(By.className(btnSignIn)).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath(btnFacebook)).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            for (String handle : tabs) {
                System.out.println(handle);
            }
            //Switch to the last tab
            driver.switchTo().window(tabs.get(1));

            driver.findElement(By.id(email)).sendKeys(fbEmail);
            driver.findElement(By.id(pass)).sendKeys(myPassword);
            WebElement lgnBtn = driver.findElement(By.xpath(loginBtn));
            if (lgnBtn.isDisplayed() && lgnBtn.isEnabled()) {
                lgnBtn.click();
                Log4j.info("Login is successful!");
            } else {
                Log4j.info("Login is failed!");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().window(tabs.get(0));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.id(searchData)).sendKeys("samsung");
            driver.findElement(By.className(searchBtn)).click();
            Log4j.info("Searched samsung");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement element = driver.findElement(By.xpath(secondPage));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement currentpage = driver.findElement(By.id(currentPage));
            String page = currentpage.getAttribute("value").toString();
            Assert.assertTrue(page.equals("2"));
            Log4j.info("Currently on the second page!");
            testPassedResult("Test Case 6 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 6 : ");
            Log4j.warning("Test Case 6 Failed!");
        }
    }
}
