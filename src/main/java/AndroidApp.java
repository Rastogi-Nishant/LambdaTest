import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidApp {

    public static String userName = "nishantrlambdatest";
    public static String accessKey = "x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT";

    public static void main(String args[]) throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 12");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("build","Demo Test");
        capabilities.setCapability("platformVersion","15");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("safariAllowPopups", true);
        capabilities.setCapability("fixedIP", "00008101-000931910C10001E");
//      `  capabilities.setCapability("fixedIP","00008101-00022D361A40001E");

//        capabilities.setCapability("app","lt://APP10160202521675092062182712");
//        capabilities.setCapability("deviceOrientation", "landscape");
//        capabilities.setCapability("console",true);
//        capabilities.setCapability("network",true);
//        capabilities.setCapability("visual",true);



//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Galaxy S20");
//        capabilities.setCapability("platformVersion","11");
//        capabilities.setCapability("name","Demo Test Android");
//        capabilities.setCapability("build","NTT TEST");
//        capabilities.setCapability("isRealMobile", true);
//        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("fixedIP","RFCNC102RQL");
//        capabilities.setCapability("gpsEnabled", true);






        //capabilities.setCapability("tunnel",true);

        //capabilities.setCapability("idleTimeout", "900");
//        capabilities.setCapability("w3c",true);

//        Runtime.getRuntime().exec("cmd /c appium --allow-insecure chromedriver_autodownload");s
//
//        capabilities.setCapability("chromedriverExecutableDir", "/Users/vishnu/Downloads");
////        capabilities.setCapability("chromedriverUseSystemExecutable",true);
//        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));


        AppiumDriver driver = new AppiumDriver(new URL("http://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);

        try {

//            driver.get("https://the-internet.herokuapp.com/geolocation");
//            Thread.sleep(5000);
//            driver.findElementByXPath("/html/body/div[2]/div/div/button").click();
//            Thread.sleep(5000);
//
//            driver.context("NATIVE_APP");
//            driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
//            driver.findElement(By.xpath(".//android.widget.Button[@text='Allow only while using the app']")).click();
//
//            Thread.sleep(60000);
//            driver.context("CHROMIUM");
//
//            driver.findElement(By.xpath("/html/body/div[2]/div/div/p/div[3]/a")).click();




            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();
            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search")));
            insertTextElement.sendKeys("LambdaTest"+ Keys.ENTER);
            Thread.sleep(5000);
//
//            Set<String> availableContexts = driver.getContextHandles();
////            System.out.printf(String.valueOf(availableContexts));
//            String context = String.valueOf(availableContexts);
//            driver.context("NATIVE_APP");
//            for(String context : availableContexts) {
//                if(context.contains("WEB_VIEW")){
//                    System.out.printf(context);
//                    driver.context(context);
//                    break;
//                }
//            }
//            driver.getContext();
//            driver.context("WEBVaIEW");

//            List allProductsName = driver.findElementsByClassName("android.widget.TextView");
//            assert(allProductsName.size() > 0);

            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");


        }catch (Exception e){

            e.printStackTrace();
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");

        }catch (AssertionError a){

            a.printStackTrace();
        }
        // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }
}