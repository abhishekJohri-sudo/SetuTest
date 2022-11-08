package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTestMethod() {

    }

    @BeforeMethod
    public void beforeMethod() {
        setupDriver();
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @AfterTest
    public void afterTestMethod() {

    }


    public void setupDriver(){
        DriverManagerType chrome = DriverManagerType.CHROME;
        WebDriverManager.getInstance(chrome).setup();

        driver = new ChromeDriver();
    }
}
