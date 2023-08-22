
import com.lambdatest.tunnel.Tunnel;
import cucumber.api.java.eo.Se;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.apache.bcel.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demoMobile {


    public RemoteWebDriver driver;
//    public AppiumDriver driver;
    public String gridURL = "mobile-hub.lambdatest.com";
    String status;
    String hub;
    String mobilehub;
    String stagehub;
    String stagemobilehub;
    String betahub;
    SessionId sessionId;
    String context[];



    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "deviceName"})
    @BeforeTest
    public void setUp(String browser, String platformVersion, String platform, String deviceName) throws Exception {
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("name", "Demo");
            capabilities.setCapability("build", "Testing");
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformVersion",platformVersion );
            capabilities.setCapability("platform", platform);
            capabilities.setCapability("network", true);
            capabilities.setCapability("console", true);
            capabilities.setCapability("visual", true);

//            capabilities.setCapability("autoAcceptAlerts", true);
//            capabilities.setCapability("tunnel", true);
//            capabilities.setCapability("appiumVersion", "1.22.1");

//            capabilities.setCapability("safariAllowPopups", true);
            //capabilities.setCapability("geoLocation", "US");
            //capabilities.setCapability("region", "eu");
//            capabilities.setCapability("fixedIP", "00008101-0002195028E1401E");
//            capabilities.setCapability("waitforIdleTimeout", 0);
//            capabilities.setCapability("appiumVersion","1.17.1");

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//            ltOptions.put("w3c", true);
//            ltOptions.put("platformName", "android");
//            ltOptions.put("deviceName", "One Plus 6T");
//            ltOptions.put("platformVersion", "9");
//            capabilities.setCapability("lt:options", ltOptions);





            StopWatch driverStart = new StopWatch();
            driverStart.start();

            hub = "https://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@hub.lambdatest.com/wd/hub";

//            mobilehub = "https://nishantrlambdatest:jDwVBvi9EedrSv2fKMTM5FMswNn5Zfh6rdiVZsTGEZcbRzyJ8B@mobile-hub.lambdatest.com/wd/hub";
//
//            betahub = "https://nishantrlambdatest:ZXYrduvNJ9CkBmO9Ja6pb0PxX89NK8yDcABazM0KZCA7OYhX1Q@mobile-hub.lambdatest.com/wd/hub";
//
//            stagehub = "https://nishantrlambdatest:4gaI6ZzlkH397HU4nMBYt3e7E6i5j8XdO3TZAdYrogVcuLB8ij@stage-hub.lambdatestinternal.com/wd/hub";
//            stagemobilehub = "https://nishantrlambdatest:4gaI6ZzlkH397HU4nMBYt3e7E6i5j8XdO3TZAdYrogVcuLB8ij@stage-us-mobile-hub.lambdatestinternal.com/wd/hub";

            driver = new RemoteWebDriver(new URL(hub), capabilities);
//            driver = new AppiumDriver(new URL(mobilehub), capabilities);
            sessionId = driver.getSessionId();
            System.out.println(sessionId);
            driverStart.stop();
            float timeElapsed = driverStart.getTime() / 1000f;
            System.out.println("Driver initiate time" + "   " + timeElapsed);
            ArrayList<Float> TotalTimeDriverSetup = new ArrayList<Float>();
            TotalTimeDriverSetup.add(timeElapsed);
            System.out.println(TotalTimeDriverSetup);


        } catch (
                MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            System.out.println(f);

        }

    }

    @Test
    public void DesktopScript() {



        try {
            WebDriverWait wait = new WebDriverWait(driver,30);



            driver.get("https://the-internet.herokuapp.com/geolocation");
            driver.findElementByXPath("/html/body/div[2]/div/div/button");

//            driver.context("NATIVE_APP");
//            driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']"));
//            driver.context("WEBVIEW");




//            driver.get("http://localhost:8000/");
//            Thread.sleep((10000));
//              driver.get("https://accounts.lambdatest.com/login");
//              driver.findElement(By.id("email")).sendKeys("nishantrlambdatest@lambdatest.com");
//              driver.findElement(By.id("password")).sendKeys("123");
//              driver.findElement(By.id("login-button")).click();

           // WINDOW CONTEXT SWITCH
//            driver.get("https://wondernetwork.com/geotest");
           //<Object String;
//            String [] context1 = driver.getContextHandles();
//            System.out.println(context1.size());
//            String s1=null;
//            for(String contexts : context1) {
//
//                System.out.println(contexts);
//                s1 = contexts;
//            }
//            driver.get("https://www.google.com");
//            driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Mindtree");
//            Thread.sleep(10000);

//            driver.get("https://www.lambdatest.com");
//            driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div[1]/div/button/img")).click();
//            Thread.sleep(10000);
//
//            driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
//            driver.findElement(By.xpath("//body/main[1]/p[3]/input[1]")).click();
//            Thread.sleep(2000);
////            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
////            //driver.get("https://ww.lambdatest.com");
////
////            //Thread.sleep(10000);
//            driver.context("NATIVE_APP");
//            driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
//            Thread.sleep(2000);
//
//            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//XCUIElementTypeTextField[contains(@value,'User Name')]")));
////            user.sendKeys("admin");
//            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Password']")).sendKeys("admin");
//            driver.findElement(By.id("Log In")).click();
//            driver.findElementById("User Name").sendKeys("admin");
//            driver.findElementById("Password").sendKeys("admin"+ Keys.ENTER);
//            driver.context("WebView");

//                driver.get("https://ltuser:%23pass123%23@retina.lambdatest.io/dashboard/?testId=5NMOR-G2SWJ-MKTD4-DHR6U");
//                Thread.sleep(10000);

//                driver.context("NATIVE_APP");
//                driver.findElement(By.xpath("//XCUIElementTypeTextField[contains(@value,'User Name')]")).sendKeys("ltuser");
//                driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Password']")).sendKeys("#pass123#");
//                driver.findElement(By.id("Log In")).click();
//                Thread.sleep(30000);
//            Set<String> context1 = driver.getContextHandles();
//            System.out.println(context1.size());
//            String s1=null;
//            for(String contexts : context1) {
//
//                System.out.println(contexts);
//                s1 = contexts;
//            }
//                Set<String> context1 = driver.getContextHandles();
//            System.out.println(context1.size());
//            String s1=null;
//            for(String contexts : context1) {
//
//                System.out.println(contexts);
//                s1 = contexts;
////            }
//                for(String context : context1) {
//                    if(context.contains("WEBVIEW")){
//                        driver.context(context);
//                        break;
//                    }
//                }
                //driver.context(con);
//            driver.context("CHROMIUM");
//            driver.get("https://www.lambdatest.com");
//            driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div[1]/div/button/img")).click();


//            driver.findElementByXPath("//*[@id=\"main-panel\"]/div/div/div[1]/div[2]/div/div[5]/span").click();
//
//
//
//
////          driver.get("https://the-internet.herokuapp.com/basic_auth");
////            Thread.sleep((30000));
////            Thread.sleep(5000);
////
//            driver.get("https://www.cebupacificair.com");
//            Thread.sleep(120000);


            driver.get("https://lambdatest.github.io/sample-todo-app/");

            driver.executeScript("smartui.takeScreenshot");
//            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement firstItem;
            firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div > div > ul > li:nth-child(1) > input")));
            WebElement secondItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(2) > input"));
            WebElement thirdItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(4) > input"));
            WebElement fifthElement = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(5) > input"));
            firstItem.click();
            secondItem.click();
            thirdItem.click();
            fifthElement.click();
            driver.findElement(By.xpath("//*[@id=\"sampletodotext\"]")).sendKeys("new item added");
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).isDisplayed();
            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).click();











//            driver.get("https://gps-coordinates.org/my-location.php");
//            Thread.sleep(10000);
////          CAPITA GEO AND CAMERA POP_UP
//            driver.get("https://demos.openvidu.io/openvidu-call/#/digital-lavender-rook");
//            Thread.sleep(3000);
//            wait.until(ExpectedConditions.elementToBeClickable(By.id("join-button")));
//            driver.findElementById("join-button").click();




//            driver.get("https://gps-coordinates.org/my-location.php");
//            Thread.sleep(2000);
//
//            driver.get("https://demos.openvidu.io/openvidu-call/#/");
//            Thread.sleep(5000);
//            driver.findElementById("joinButton").click();
//            Thread.sleep(5000);
//
//            driver.get("https://qatesting.eye999.co.uk/eye/c.html?id=mr36gxJF");
//            Thread.sleep(155000);
//            driver.get("https://demos.openvidu.io/openvidu-call/#/");
//            driver.findElementById("joinButton").click();
////
//
// INTERNETSTORES ANDROID POP UP
//            System.out.println("OPEN URL");
//            driver.get("https://www.fr.campz.ch/");
//            Cookie cookie = new Cookie("kameleoonOptout", "true");
//            driver.manage().addCookie(cookie);
//            //Thread.sleep(5000);
//            System.out.println("Click on Pop-up");
//            driver.findElementByXPath("/html/body/div[10]/div[3]/div/div/div[2]/div/div/button").click();
//
//            Thread.sleep(10000);
//
//            System.out.println("OPEN URL");
//            driver.get("https://www.addnature.fi/");
//            driver.manage().addCookie(cookie);
//            System.out.println("Click on Pop-up");
//            driver.findElementById("onetrust-accept-btn-handler").click();
//            System.out.println("Select the item");
            ///html/body/div[9]/div[3]/div/div/div[2]/div/div/button



            //BORN
//            public String writeInInput(String object, String data) {
//                APP_LOGS.debug("Writing in text box "+object);

//                try {
//                    driver.get("https://storefront:l1oveJoy110@staging-eu01-converse.demandware.net/s/converse-eu-west-2/register?lang=fr_FR");
//                    Thread.sleep(2000);
//                    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/form/button[2]")).click();
//                    Thread.sleep(2000);
//                    driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/div[1]/div/div[2]/form/div[5]/div/div[2]/div[1]/div/div/input")).sendKeys("10/05/2021");
//
//                } catch (Exception e) {
//                    System.out.println(e);
//
//                }





//            driver.get("https://the-internet.herokuapp.com/basic_auth");
//            Thread.sleep(30000);
//
            //CLEARVIEW
//            driver.get("https://uat.qssweb.com/");
//            driver.findElementById("ctl00_LoginUser_UserName").sendKeys("Test");
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
        }
    }
}





