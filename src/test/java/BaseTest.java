import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    protected final String n11_Url = "https://www.n11.com/";
    protected final String fbEmail ="test.automation.project96@gmail.com";
    protected final String myPassword = "Test2020";
    protected final String confirmPassword = "Test2020";
    protected String btnClose = "closeBtn";
    protected String btnFacebook = "//*[@id=\"loginContainer\"]/div/div[1]/div/div[3]";
    protected String loginBtn = "//*[@id=\"u_0_0\"]";
    protected String pass = "pass";
    protected String btnSignIn = "btnSignIn";
    protected String email = "email";
    protected String searchData = "searchData";
    protected String searchBtn = "searchBtn";
    protected String resultText = "resultText";
    protected String secondPage = ".//*[@id='contentListing']/div/div/div[2]/div[4]/a[2]";
    protected String currentPage = "currentPage";
    protected String menuFavorite = "//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[5]/a";
    protected String myFavorite = "//*[@id='myAccount']/div[3]/ul/li[1]/div/a";
    protected String thirdProductItem = ".//*[@id='view']/ul/li[3]/div/div[1]/span[@class='textImg followBtn']";
    protected String listItemWrap = "listItemWrap";
    protected String deleteFavoriteProduct = ".wishProBtns span.deleteProFromFavorites";
    protected String btnHolder = "btnHolder";
    protected String emptyWatchList = "//*[@id='watchList']/div";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-notifications");
        options.addArguments("test-type");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Log4j.startLog("Test is Starting!");
    }

    @AfterMethod
    public void tearDown() {
        Log4j.endLog("Test is Ending!");
        driver.quit();
    }

    public void testPassedResult(String testCase) throws IOException {
        Workbook wb = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\olcay\\TestAutomationProject\\n11_TestAutomationProject\\testResult.xls");
        Sheet sheet = wb.createSheet("Sheet1");
        Row row0 = sheet.createRow((short) 0);
        Cell cell = row0.createCell(0);
        cell.setCellValue(testCase + "Test Passed!");
        wb.write(fileOut);
        fileOut.close();
    }

    public void testFailedResult(String testCase) throws IOException {
        Workbook wb = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\olcay\\TestAutomationProject\\n11_TestAutomationProject\\testResult.xls");
        Sheet sheet = wb.createSheet("Sheet1");
        Row row0 = sheet.createRow((short) 0);
        Cell cell = row0.createCell(0);
        cell.setCellValue(testCase + "Test Failed!");
        wb.write(fileOut);
        fileOut.close();
    }
}
