package com.lambdatest;

import com.lambdatest.tunnel.Tunnel;
import cucumber.api.java.eo.Se;
import gherkin.lexer.Th;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
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

public class Experimental {

//    public String username = "nishantrlambdatest";
//    public String accesskey = "qJWmY51AY1vdlTC04Kh4iPttDsTgVl330z39YG4FadfqebaTSo";
//    public RemoteWebDriver driver;
//    public String gridURL = "hub.lambdatest.com";
//    String status;
//    String hub;
//    SessionId sessionId;
    public static WebDriver webDriver;
//
//
//    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "timezone"})


    public static void main(String args[]) throws Exception {
        try {

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("build", "IS SCROLL");
//            caps.setCapability("name", "test");
//            caps.setCapability("platform", platform);
//            caps.setCapability("browserName", browser);
//            caps.setCapability("version", version);
//            caps.setCapability("visual", true);
//            caps.setCapability("resolution", "1280x1024");
//            caps.setCapability("viewportSize", "1280x870");
//            caps.setCapability("fixedIP", "10.82.0.126");

//            caps.setCapability("network", true);

//            caps.setCapability("tunnel", true);
//            caps.setCapability("idleTimeout", "270");
//            caps.setCapability("region", "us");
//            caps.setCapability("headless", true);

            StopWatch driverStart = new StopWatch();
            driverStart.start();

//            https://vikast:LyepAsZzzl1AH7abv4rXYnSHIgjlIUFbMwxuDQj2ECR7OQ3sPT@hub.timezone.dev.lambdatest.io/wd/hub
//            hub = "https://nishantrlambdatest:qJWmY51AY1vdlTC04Kh4iPttDsTgVl330z39YG4FadfqebaTSo@hub.timezone.dev.lambdatest.io/wd/hub";
//            driver = new RemoteWebDriver(new URL("https://snaveen:V44LDBUdI1m8hMyg5g9O78hkQKB0AWJ7Um2N7RtJWlba9FjP3g@hub.lambdatest.com/wd/hub"), caps);
//            driver = new RemoteWebDriver(new URL("https://sarveshd:bEhUuLO8UqSkb64B60mioAFjgdGuEV1QRqsO9jpXXwWoFHCRom@stage-hub.lambdatest.com/wd/hub"), caps);
//            driver = new RemoteWebDriver(new URL("https://nishantrlambdatest:VJVuN5xCCqqWFcTzYyYwHeEmaHVIkHOuMqU9TNCL247krOL9Aq@hub.lambdatest.com/wd/hub"), caps);
            SafariOptions options = new SafariOptions();
            webDriver = new SafariDriver();

//            System.out.println(timezone + ((JavascriptExecutor) driver).executeScript("return new Date().toString();"));
            WebDriverWait wait = new WebDriverWait(webDriver, 30);
            webDriver.manage().window().maximize();

            System.out.println("OPEN URL");
            webDriver.get("https://www.addnature.fi/");
            System.out.println("Click on Pop-up");
            webDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
            System.out.println("Select the item");
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("/html/body/div[4]/div/main/div[1]/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[3]/div/div/div[1]/div/div[1]/div/a")).click();
            System.out.println("Click on Add to cart");
            Thread.sleep(2000);
            webDriver.findElement(By.id("add-to-cart")).click();
            System.out.println("Click to Choose Size");
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("/html/body/div[5]/div/main/div/div[3]/div/div[2]/div/div[2]/div[3]/div[5]/form/fieldset/div[1]/div/ul/li[2]/div/div[2]/div/div/div[6]/div[1]/div")).click();
            System.out.println("Click on Kassalle");
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("/html/body/header/div/div[1]/div[3]/ul/li[4]/div[3]/div[2]/div[5]/a")).click();
            System.out.println("Click on klarna checkout");
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div[5]/div[1]/div[2]/div[2]/div/a")).click();
            System.out.println("Switch to Frame");
            Thread.sleep(5000);
            webDriver.switchTo().frame("klarna-checkout-iframe");
            System.out.println("Enter Email");
            Thread.sleep(5000);
            WebElement el = webDriver.findElement(By.id("terms-banner__alt-link"));
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", el);
            Thread.sleep(2000);
            WebElement email = webDriver.findElement(By.xpath("billing-email"));
            webDriver.quit();

//            driverStart.stop();
//            float timeElapsed = driverStart.getTime() / 1000f;
//            System.out.println("Driver initiate time" + "   " + timeElapsed);
//            ArrayList<Float> TotalTimeDriverSetup = new ArrayList<Float>();
//            TotalTimeDriverSetup.add(timeElapsed);
//            System.out.println(TotalTimeDriverSetup);


//        } catch (
//                MalformedURLException e) {
//            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            System.out.println("InExceptionBlock");
            System.out.println(f);
            webDriver.quit();
//
        }

    }


//    public void DesktopScript() {
//        try {
////            DEMO SCRIPT
////            driver.get("http://viewportsizes.mattstow.com/mine/");
////            driver.get("https://lambdatest.github.io/sample-todo-app/");
////            Thread.sleep(3000);
////            WebDriverWait wait = new WebDriverWait(driver, 30);
////            WebElement firstItem;
////            firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div > div > ul > li:nth-child(1) > input")));
////            WebElement secondItem = driver.f0indElement(By.cssSelector("body > div > div > div > ul > li:nth-child(2) > input"));
////            WebElement thirdItem = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(4) > input"));
////            WebElement fifthElement = driver.findElement(By.cssSelector("body > div > div > div > ul > li:nth-child(20) > input"));
////            firstItem.click();
////            secondItem.click();
////            thirdItem.click();
////            fifthElement.click();
////            driver.findElement(By.xpath("//*[@id=\"sampletodotext\"]")).sendKeys("new item added");
////            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).isDisplayed();
////            driver.findElement(By.xpath("//*[@id=\"addbutton\"]")).click();
////            System.out.println(((JavascriptExecutor) driver).executeScript("return navigator.userAgent"));
////            status="passed";
//
////            LOCALHOST
////            driver.get("http://localhost.lambdatest.com:8000");
////            Thread.sleep(10000);
//
////            MSSCRIPT
////            System.out.println("URL");
////            driver.get("https://mcastest14-my.sharepoint.com");
////            Thread.sleep(5000);
////            System.out.println("Enter Username details");
////            driver.findElementByXPath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]").sendKeys("lambdatest@mcas-test14.com");
////            System.out.println("Click on Next");
////            driver.findElementByXPath("//input[@type='submit']").click();
////            Thread.sleep(5000);
////            System.out.println("Enter Password details");
////            driver.findElementByXPath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input").sendKeys("4Lambda2Test");
////            System.out.println("Click on SignIN");
////            driver.findElementByXPath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div/input").click();
////            System.out.println("Click on Yes");
////            driver.findElementByXPath("//input[@type='submit']").click();
////            System.out.println("Is Displayed");
////            System.out.println(driver.findElementByXPath("//input[@type='submit' and @id='hiddenformSubmitBtn']").isDisplayed());
////            driver.findElementByXPath("//input[@type='submit']").click();
////            System.out.println("Click on Continue to Microsoft One Drive");
////            driver.findElementByXPath("//input[@type='submit' and @id='hiddenformSubmitBtn']");
////            System.out.println(((JavascriptExecutor) driver).executeScript("return new Date().toString();"));
//
//
//            //INTERNETSTORES
//
////
////           ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", email);
////            Thread.sleep(2000);
////            email.sendKeys("abc@abcde.com");
////            System.out.println("Enter Postal Code");
////            driver.findElementByName("postal_code").sendKeys("33610");
////
////            WebElement Jatkabtn = driver.findElementById("button-primary");
////            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Jatkabtn);
////            System.out.println("Scrolled jatka Button to view and Clicked on it");
////            Thread.sleep(10000);
////            Actions a = new Actions(driver);
////            a.moveToElement(Jatkabtn);
////            driver.findElementById("button-primary").click();
////            WebElement num = driver.findElementById("billing-phone");
////            Actions b = new Actions(driver);
////            b.moveToElement(num);
////            Thread.sleep(2000);
////            System.out.println("Enter First Name");
////            driver.findElementById("billing-given_name").sendKeys("abc");
////            System.out.println("Enter Last Name");
////            driver.findElementById("billing-family_name").sendKeys("abc");
////            System.out.println("Enter Address");
////            driver.findElementById("billing-street_address").sendKeys("Ysitie 23, Pirkanmaa,");
////            System.out.println("Enter City");
////            driver.findElementById("billing-city").sendKeys("Tampere");
////            System.out.println("Enter billing-phone");
////            driver.findElementById("billing-phone").sendKeys("046 733 8737");
////            Thread.sleep(2000);
////            System.out.println("Click jatka Button");
////            driver.findElementById("button-primary").click();
////            Thread.sleep(2000);
////            System.out.println("Click jatka Button again");
////            driver.findElementById("button-primary").click();
////
////
////            driver.findElementByXPath("/html/body/header/div/div[1]/div[3]/ul/li[4]/div[3]/div[2]/div[5]").click();
////            Thread.sleep(5000);
////
////            //driver.findElementByXPath("/html/body/header/div/div[1]/div[3]/ul/li[4]/div[3]/div[2]/div[5]/a").click();
////            driver.findElementByXPath("/html/body/header/div/div[1]/div[3]/ul/li[4]/div[3]/div[2]/div[5]/a").click();
////            Thread.sleep(5000);
//
//            //scroll( arguments[0].scrollIntoView(), arguments[0].scrollIntoViewIfNeeded(true);
////            Code to scroll button to view
////            WebElement Jatkabtn = driver.findElementById("button-primary");
////            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Jatkabtn);
//
////            WebElement l = driver.findElementByXPath("/html/body/div/div/div/div/div/div[5]/div/div/div/label/span/p");
////            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
//
//
//
//
//
//
////            EXTRA
////            driver.get("https://test.cox.com/myprofile/home.html");
////            Thread.sleep(100000);
////            driver.get("https://apps.trepp.com");
////            Thread.sleep(5000);
////            driver.get("https://www.google.com");
////            System.out.println(((JavascriptExecutor)driver.executeScript("return navigator.appVersion")));
////            driver.findElementByXPath("/html/body/div[4]/div/main/div[1]/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div[1]/div/div[1]/div/a").click();
////            System.out.println("https://smallseotools.com/what-is-my-browser/");
////            driver.get("https://smallseotools.com/what-is-my-browser/");
////            System.out.println(driver.findElementByXPath("/html/body/div[11]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]").getText());
//
//
//        } catch (Exception e) {
//
//            System.out.println(e);
//            status = "failed";
//        }
//    }
//
//
//
//        }
//    }
}

