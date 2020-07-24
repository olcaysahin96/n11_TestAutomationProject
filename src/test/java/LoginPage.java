import com.sun.org.glassfish.gmbal.Description;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.qameta.allure.Story;
import org.openqa.selenium.By;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseTest {
    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Story("Facebook ile login olacak (facebook'ta login değilken facebook butonuna bastığında, facebook kullanıcı pass istemeli.)")
    public void TestCase1() throws IOException {
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
            Log4j.info("Email: " + fbEmail);
            driver.findElement(By.id(pass)).sendKeys(myPassword);
            driver.findElement(By.id(pass)).clear();
            driver.findElement(By.id(pass)).sendKeys(confirmPassword);
            if (myPassword != confirmPassword) {
                Log4j.warning("Mismatch Password!");
            } else {
                Log4j.info("Password: " + confirmPassword);
            }
            WebElement lgnBtn = driver.findElement(By.xpath(loginBtn));
            if (lgnBtn.isDisplayed() && lgnBtn.isEnabled()) {
                lgnBtn.click();
                Log4j.info("Login is successful!");
            } else {
                Log4j.info("Login is failed!");
            }
            Thread.sleep(5000);
            driver.switchTo().window(tabs.get(0));
            testPassedResult("Test Case 1 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 1 : ");
            Log4j.warning("Test Case 1 Failed!");
        }
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("<https://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak")
    public void TestCase2() throws IOException {
        try {
            driver.get(n11_Url);
            driver.findElement(By.className(btnClose)).click();
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(n11_Url, currentUrl);
            if (driver.getCurrentUrl().equals(n11_Url)) {
                Log4j.info("Welcome to https://www.n11.com/");
            } else {
                Log4j.info("Wrong Web Site Url!");
            }
            testPassedResult("Test Case 2 : ");
        } catch (Exception e) {
            testFailedResult("Test Case 2 : ");
            Log4j.warning("Test Case 2 Failed!");
        }
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Login ekranini acip, bir kullanici ile login olacak(daha once siteye uyeliginiz varsa o olabilir")
    public void TestCase3() throws InterruptedException, IOException {
        try{
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
        Log4j.info("Email: " + fbEmail);
        driver.findElement(By.id(pass)).sendKeys(myPassword);
        driver.findElement(By.id(pass)).clear();
        driver.findElement(By.id(pass)).sendKeys(confirmPassword);
        if (myPassword != confirmPassword) {
            Log4j.warning("Mismatch Password!");
        } else {
            Log4j.info("Password: " + confirmPassword);
        }

        WebElement lgnBtn = driver.findElement(By.xpath(loginBtn));
        if (lgnBtn.isDisplayed() && lgnBtn.isEnabled()) {
            lgnBtn.click();
            Log4j.info("Login is successful!");
        } else {
            Log4j.info("Login is failed!");
        }
        Thread.sleep(5000);
        driver.switchTo().window(tabs.get(0));
        testPassedResult("Test Case 3 : ");
        }
        catch (Exception e) {
            testFailedResult("Test Case 3 : ");
            Log4j.warning("Test Case 3 Failed!");
        }
    }
}
