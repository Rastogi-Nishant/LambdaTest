import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;

public class LocaltoLambda {

    public static void main(String[] args) throws InterruptedException, FindFailed, MalformedURLException {
        // Open web browser, maximize and browse Disney World webs
        //***********************LOCAL DRIVER*******************
//        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver","/Users/neeraj/Projects/Drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

        //***********************REMOTE DRIVER*******************
        RemoteWebDriver driver;
////
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability ("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion","106.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();

        ltOptions.put("project", "DemoToday");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        ltOptions.put("build", "Bootcamp 03.05");
        browserOptions.setCapability("LT:Options", ltOptions);
////
////
        driver = new RemoteWebDriver(new URL("https://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@hub.lambdatest.com/wd/hub"), browserOptions);
        try {


            driver.get("https://lambdatest.github.io/sample-todo-app/");
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement firstItem;
            firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div > div > ul > li:nth-child(1) > input")));
            WebElement secondItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(2) > input"));
            Thread.sleep(1000);
            WebElement thirdItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(4) > input"));
            Thread.sleep(1000);
//            WebElement fifthElement = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(20) > input"));
            firstItem.click();
            secondItem.click();
            thirdItem.click();
//            fifthElement.click();
            driver.findElement(By.xpath("//*[@id=\"sampletodotext\"]")).sendKeys("new item added");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).isDisplayed();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).click();
            Thread.sleep(1000);
            System.out.println(((JavascriptExecutor) driver).executeScript("return navigator.userAgent"));
            Thread.sleep(1000);

        }
        catch (Exception e)
        {}
    }
}
