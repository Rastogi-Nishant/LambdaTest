package com.lambdatest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
public class CoinDCX
{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "OnePlus 7");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("orientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("project", "labs");
        capabilities.setCapability("build", "coindcx");
        capabilities.setCapability("autoGrantPermissions", true);
        //    android
        capabilities.setCapability("app", "lt://APP100201841649414978671734");

        AndroidDriver driver = new AndroidDriver(
                new URL("https://nishantrlambdatest:qJWmY51AY1vdlTC04Kh4iPttDsTgVl330z39YG4FadfqebaTSo@beta-hub.lambdatest.com/wd/hub"),
                capabilities);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Thread.sleep(2000);
            driver.activateApp("com.android.chrome");
            Thread.sleep(2000);
            ((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
            Thread.sleep(2000);
            driver.getContext();
            Thread.sleep(2000);
            driver.getContextHandles();
            Thread.sleep(5000);
            driver.context("WEBVIEW_chrome");
            Thread.sleep(5000);
            driver.getCurrentUrl();
            Thread.sleep(2000);
            driver.get("https://google.com");
            driver.close();
           // ((AndroidDriver) driver).close();
            Thread.sleep(5000);
            //      driver.terminateApp("com.android.chrome");
            //      driver.activateApp("com.coindcx.btc");
            Thread.sleep(2000);
            driver.quit();
        } catch (Exception e) {
            System.out.println(e);
            driver.quit();
        }
    }
}