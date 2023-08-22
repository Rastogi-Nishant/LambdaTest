package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Moovit {
    WebDriver driverTst;
    private AppiumDriverLocalService service;
    public AndroidDriver driver;
//    private static final ServerManager SERVER_MANAGER = ServerManager.getInstance();
//    String appActivity=PropertyManager.readProperty("appActivity");
//    String platformName=PropertyManager.readProperty("platformName");
//    String deviceName=PropertyManager.readProperty("deviceName");
//    String platformVersion=PropertyManager.readProperty("platformVersion");
//    String udid=PropertyManager.readProperty("udid");
//    String UiAutomator2=PropertyManager.readProperty("UiAutomator2");
//    String appPackage=PropertyManager.readProperty("appPackage");
//    String lat_origin=PropertyManager.readProperty("lat_origin");
//    String long_origin=PropertyManager.readProperty("long_origin");
//    String lat_dest=PropertyManager.readProperty("lat_dest");
//    String long_dest=PropertyManager.readProperty("long_dest");
//    String origin=PropertyManager.readProperty("origin");
//    String dest=PropertyManager.readProperty("dest");
//    String licens_key=PropertyManager.readProperty("licens_key");
//    String driver_id=PropertyManager.readProperty("driver_id");
//    String vhicle_id=PropertyManager.readProperty("vhicle_id");
//    public String gridURL = "@beta-hub.lambdatest.com/wd/hub";
//    @BeforeSuite
//    public void startAppiumServer() {
//    SERVER_MANAGER.startServer();
//}
    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "deviceName"})
    @BeforeTest
    public void setup(String browser, String platformVersion, String platform, String deviceName) throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Galaxy S21 5G");
        cap.setCapability("platformVersion", "12.0");
//      cap.setCapability("udid", udid);
//      cap.setCapability("automationName", UiAutomator2);
//      cap.setCapability("appActivity", appActivity);
//      cap.setCapability("appPackage", appPackage);
        cap.setCapability("isRealMobile", true);
//      cap.setCapability("deviceId","192.168.1.24:40349");
//        cap.setCapability("fullReset",true);
//        cap.setCapability("appWaitForLaunch",false);
//        cap.setCapability("unicodeKeyboard", true);
//        cap.setCapability("resetKeyboard", true);
//        cap.setCapability("browserstack.user", "benjaminkun_1PvZ0C");
//        cap.setCapability("browserstack.key", "ESBB8xpQhbZEnQNAVWac");
        cap.setCapability("app", "lt://APP100202151634649275590734");
        //cap.setCapability("otherApps", new String[]{"lt://APP100202361653299728033769"});

        DesiredCapabilities capsWeb = new DesiredCapabilities();
        capsWeb.setCapability("resolution", "1920x1080");
        capsWeb.setCapability("browserName", "Chrome");
        capsWeb.setCapability("version", "latest");
        capsWeb.setCapability("platform", "Windows 10");
        String hub = "https://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@hub.lambdatest.com/wd/hub";

        driver = new AndroidDriver(new URL("https://nishantrlambdatest:VJVuN5xCCqqWFcTzYyYwHeEmaHVIkHOuMqU9TNCL247krOL9Aq@mobile-hub.lambdatest.com/wd/hub"), cap);
        driverTst = new RemoteWebDriver(new URL(hub), capsWeb);


    }
    @Test
    public void Test()
    {
        driverTst.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
//        testContext.setAttribute("WebDriver", this.driverTst);
        driverTst.get("https://stg-tod.moovit.com/dispatcher/live?zoneId=561&panel=orders");
        driverTst.findElement(By.cssSelector("#email_input")).sendKeys("");
        driverTst.findElement(By.cssSelector("#password_input")).sendKeys("");
        driverTst.findElement(By.cssSelector("[data-automation=\"login-button\"]")).click();
        driverTst.manage().window().maximize();
//        Location location1 = new Location(32.37934258355358, 34.92776323199668, 0);
        Location location1 = new Location(32.35976220956003, 34.907154307172306, 0);
//        Location location1 = new Location(34.236379063789144, -77.9496417662934, 0);
//        Location location1 = new Location(-37.91936669004181, 145.23706134620022, 0);
        driver.setLocation(location1);
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
       // driver.activateApp("com.moovit.driver.stg.debug");
//        DriverPage driverApp = new DriverPage(driver);
//        driverApp.logOffDriver();
      //  driver.terminateApp("com.moovit.driver.stg.debug");
        Thread.sleep(2000);
//        driver.resetApp();
        driver.quit();
        driverTst.quit();
    }
//    @AfterMethod
//    public void failedTest(ITestResult result) {
//        // check if the test failed
//        if (result.getStatus() == ITestResult.FAILURE) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File srcFile = ts.getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            // result.getname() method will give you current test case name.
            // ./ScreenShots/ tell you that, in your current directory, create folder
            // ScreenShots. dot represents current directory
      //  }
    //}
//    @AfterSuite(alwaysRun = true)
//    public void stopAppiumServer() {
////        if (SERVER_MANAGER.isServiceRunning())
////            SERVER_MANAGER.stopServer();
//        //driverTst.quit();
//    }
}