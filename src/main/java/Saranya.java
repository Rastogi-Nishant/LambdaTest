import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;

public class Saranya {

    public static void main(String[] args) throws InterruptedException, FindFailed, MalformedURLException {
        // Open web browser, maximize and browse Disney World webs
        //***********************LOCAL DRIVER*******************
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/nishantr/Projects/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //***********************REMOTE DRIVER*******************
//        RemoteWebDriver driver;
//
//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setCapability ("platformName", "Windows 10");
//        browserOptions.setCapability("browserVersion","106.0");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "nishantrlambdatest");
//        ltOptions.put("accessKey", "x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT");
//        ltOptions.put("project", "Untitled");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        ltOptions.put("build", "Saranya");
//        browserOptions.setCapability("LT:Options", ltOptions);
//
//
//        driver = new RemoteWebDriver(new URL("https://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@hub.lambdatest.com/wd/hub"), browserOptions);
        try {


            driver.get("https://qa.internal.nutshellapps.com/");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nutshellaccs+lambdasupport@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Lambda.1");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(2000);

            Actions ac = new Actions(driver);
            //Navigate to Apps page
            driver.findElement(By.xpath("//div[contains(text(),'APPS')]")).click();
            Thread.sleep(6000);

            //Double click the folder
            ac.doubleClick(driver.findElement(By.xpath("//div[text()='Nutshell_Lambda']"))).build().perform();
            Thread.sleep(5000);

            // to open the "Sikuli_app"
            ac.doubleClick(driver.findElement(By.xpath("//div[contains(text(),'Sikuli_test')]"))).build().perform();
            Thread.sleep(4000);

            //drag drop screen component into canvas
            ac.dragAndDropBy(driver.findElement(By.id("toolbar_item_create_screen")), 400, 400).build().perform();
            Thread.sleep(2000);
            //Edit properties to include header on the screen
            driver.findElement(By.id("headfoot-header")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("screen_properties_header")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("sidebar_button_apply")).click();
            Thread.sleep(10000);

            //To click header in the screen
            // create object of screen to use Sikuili API commands
            Screen s = new Screen();
            Pattern p1 = new Pattern(System.getProperty("user.dir") + "/header.PNG");
            //Thread.sleep(5000);
            s.click(p1);
            Thread.sleep(10000);

            //To edit the background colour for the header
            driver.findElement(By.id("section_background_color")).click();
            ac.dragAndDropBy(driver.findElement(By.xpath("(//div[@class='minicolors-picker'])[3]")), 35, 35).build().perform();
            driver.findElement(By.id("sidebar_button_apply")).click();
            Thread.sleep(2000);
            driver.close();
        }
        catch (Exception e)
        {}
    }
}
