
import com.lambdatest.tunnel.Tunnel;
import cucumber.api.java.eo.Se;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.cache.annotation.CacheAnnotationParser;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class demoDesktop {

    public String username = "nishantrlambdatest";
    public String accesskey = "x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT";
    public RemoteWebDriver driver;
    public String gridURL = "hub.lambdatest.com";
    String status;
    String hub;
    SessionId sessionId;
    public WebDriver webDriver;
    Tunnel t;
//    public void switchToParentWindowHandle() {
//        driver.switchTo().window(parentWindowHandle);
//    }
//    public void getParentWindowHandle() {
//        parentWindowHandle = driver.getWindowHandle();
//    }
//    private String parentWindowHandle;
//
//    public void switchToWindow(String title) {
//        boolean foundWindow = false;
//        getParentWindowHandle(); //See above reference
//
//        for (String handle : driver.getWindowHandles()) {
//            System.out.println("Switching to window with id:" + handle);
//            if (driver.switchTo().window(handle).getTitle().contains(title)) {
//                System.out.println("Switched to window with title:" + title);
//                foundWindow = true;
//                break;
//            }
//        }
//
//        if (foundWindow) {
//            System.out.println("found the window with title -> " + title +  "\nSwitching to parent window.");
//            switchToParentWindowHandle(); //See above reference
//        }
//    }


    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "timezone"})

    @BeforeTest
    public void setUp(String browser, String version, String platform, String timezone) throws Exception {
        try {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("build", "Testathon");
            caps.setCapability("name", "test");
            caps.setCapability("platform", platform);
            caps.setCapability("browserName", browser);
            caps.setCapability("version", version);
            caps.setCapability("visual", true);
            caps.setCapability("network", true);
            caps.setCapability("console", true);
            caps.setCapability("performance", true);


            StopWatch driverStart = new StopWatch();
            driverStart.start();
            driver = new RemoteWebDriver(new URL("https://"+username+":"+accesskey+"@"+gridURL+"/wd/hub"), caps);
            System.out.println(driver);

            System.out.println(timezone + ((JavascriptExecutor) driver).executeScript("return new Date().toString();"));

            sessionId = driver.getSessionId();
            System.out.println(sessionId);

        } catch (Exception f) {
            System.out.println(f);
        }
    }
    @Test


    public void DesktopScript() {
        try {
//
            driver.get("https://lambdatest.github.io/sample-todo-app/");
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement firstItem;
            firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div > div > ul > li:nth-child(1) > input")));
            WebElement secondItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(2) > input"));
            Thread.sleep(10000);
            WebElement thirdItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(4) > input"));
            Thread.sleep(10000);
//            WebElement fifthElement = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(20) > input"));
            firstItem.click();
            secondItem.click();
            thirdItem.click();
//            fifthElement.click();
            driver.findElement(By.xpath("//*[@id=\"sampletodotext\"]")).sendKeys("new item added");
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).isDisplayed();
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).click();
            Thread.sleep(10000);
            System.out.println(((JavascriptExecutor) driver).executeScript("return navigator.userAgent"));
            Thread.sleep(10000);
            status="passed";

        } catch (Exception e) {

            System.out.println(e);
            status = "failed";
        }
    }


    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
            t.stop();
        }
    }
}

