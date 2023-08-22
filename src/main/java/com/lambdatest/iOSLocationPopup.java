package mobilerealdevice.customerScripts.SampleScript;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utility.utility.MobileAutomationHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class iOSLocationPopup{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone.*");
//    capabilities.setCapability("platformVersion", "14");
        //    capabilities.setCapability("fixedIP", "00008101-0016210A0A68801E");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("orientation", "PORTRAIT");
//    capabilities.setCapability("autoWebview", true);
//    capabilities.setCapability("project", "project");
        capabilities.setCapability("build", "sampleiosPopCheck");
//    capabilities.setCapability("app", "iOSSampleApp");
        //    capabilities.setCapability("privateCloud", true);

        //    AppiumDriver driver = new AppiumDriver(
        //      new URL("https://paragj:f1ba0PpwwfkErIGyr5BGAM0er0q3lIS1Q1sHcfCPEO0tsg4jg2@stage-mobile-hub.lambdatestinternal.com/wd/hub"),
        //      capabilities);
        AppiumDriver driver = new AppiumDriver(
                new URL("https://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@mobile-hub.lambdatest.com/wd/hub"),
                capabilities);
        try {
            driver.get("https://www.google.com/search?q=book+my+show&oq=book+my+show&aqs=chrome..69i57.5331j0j4&sourceid=chrome&ie=UTF-8");

            Thread.sleep(3000);
            driver.context("NATIVE_APP");
            for (int i = 0; i < 3; i++) {
                if(driver.findElementsByAccessibilityId("Read more").size()>0){
                    driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Read more\"]").click();
                    Thread.sleep(3000);
                }
            }

            Thread.sleep(3000);
            if(driver.findElementsByAccessibilityId("Accept all").size()>0){
                driver.findElementByAccessibilityId("Accept all").click();

                String currentContext = driver.getContext();
                System.out.println("Current Context: " + currentContext);

                Set<String> availableContexts = driver.getContextHandles();
                for (String context : availableContexts) {
                    if (context.contains("WEBVIEW")) {
                        driver.context(context);
                        break;
                    }
                }

                String updatedContext = driver.getContext();
                System.out.println("Updated Context: " + updatedContext);

                // Navigate to a URL in the webview
//        driver.get("https://www.example.com");

                driver.get("https://www.google.com/search?q=book+my+show&oq=book+my+show&aqs=chrome..69i57.5331j0j4&sourceid=chrome&ie=UTF-8");
                driver.context("NATIVE_APP");
            }

            Thread.sleep(5000);
            if(driver.findElementsByAccessibilityId("Allow Once").size()>0){
                driver.findElementByAccessibilityId("Allow Once").click();
            }

            Thread.sleep(3000);
            if(driver.findElementsByAccessibilityId("Allow").size()>0){
                driver.findElementByAccessibilityId("Allow").click();
            }
            driver.executeScript("lambda-status=passed");
            Thread.sleep(3000);
            if(driver.findElementsByAccessibilityId("Ok").size()>0){
                driver.executeScript("lambda-status=failed");
            }



            driver.quit();
        } catch (Exception e) {
            driver.executeScript("lambda-status=failed");
            driver.quit();
        }

    }
}
