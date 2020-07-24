import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FavoritePage extends BaseTest {
    @Test(priority = 7)
    @Story("Ustten 3.urunun icindeki 'favorilere ekle' butonuna tiklayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase7() throws InterruptedException, IOException {
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
            WebElement element = driver.findElement(By.xpath(secondPage));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
            Log4j.info("Currently on the second page!");
            Thread.sleep(3000);
            WebElement addFavorite = driver.findElement(By.xpath(thirdProductItem));
            addFavorite.click();
            Log4j.info("Third product added to favorite!");
            testPassedResult("Test Case 7 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 7 : ");
            Log4j.warning("Test Case 7 Failed!");
        }
    }

    @Test(priority = 8)
    @Story("Ekranin en ustundeki 'favorilerim' linkine tiklayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase8() throws IOException {
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
            driver.findElement(By.linkText("Hesabım")).click();
            driver.findElement(By.xpath(menuFavorite)).click();
            Log4j.info("Menu favorite page is on displayed!");
            testPassedResult("Test Case 8 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 8 : ");
            Log4j.warning("Test Case 8 Failed!");
        }
    }

    @Test(priority = 9)
    @Story("Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase9() throws IOException {
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
            driver.findElement(By.linkText("Hesabım")).click();
            driver.findElement(By.xpath(menuFavorite)).click();
            WebElement favorite = driver.findElement(By.className(listItemWrap));
            Assert.assertTrue(favorite.getText().contains("Favorilerim (1)"));
            testPassedResult("Test Case 9 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 9 : ");
            Log4j.warning("Test Case 9 Failed!");
        }
    }

    @Test(priority = 10)
    @Story("Favorilere eklenen bu ürünün içine girilip 'Sil' butonuna basılacak, favori listesinden çıkarılacak")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase10() throws IOException {
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
            driver.findElement(By.linkText("Hesabım")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath(menuFavorite)).click();
            driver.findElement(By.xpath(myFavorite)).click();
            Log4j.info("My favorite page is on displayed!");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(deleteFavoriteProduct)).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.className(btnHolder)).click();
            Log4j.info("My favorite product is deleted!");
            testPassedResult("Test Case 10 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 10 : ");
            Log4j.warning("Test Case 10 Failed!");
        }
    }

    @Test(priority = 11)
    @Story("Sayfada bu urunun artik favoriler olmadıgını onaylayacak.")
    @Severity(SeverityLevel.NORMAL)
    public void TestCase11() throws IOException {
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
            driver.findElement(By.linkText("Hesabım")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath(menuFavorite)).click();
            driver.findElement(By.xpath(myFavorite)).click();
            Log4j.info("My favorite page is on displayed!");
            WebElement emptyList = driver.findElement(By.xpath(emptyWatchList));
            Assert.assertTrue(emptyList.getText().contains("İzlediğiniz bir ürün bulunmamaktadır."));
            Log4j.info("There is no product you are following!");
            testPassedResult("Test Case 11 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 11 : ");
            Log4j.warning("Test Case 11 Failed!");
        }
    }
}
