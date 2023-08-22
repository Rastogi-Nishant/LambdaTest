package com.lambdatest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

public class visualui {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver = null;

        Hashtable<String, Integer> errorColor= new Hashtable<>();
        errorColor.put("red",500);
        errorColor.put("green",0);
        errorColor.put("blue",0);

        HashMap<String,Object> output= new HashMap<String, Object>();
        output.put("errorColor",errorColor);//Output Difference error color
        output.put("transparency",0.1);// Set transparency of Output
        output.put("largeImageThreshold",5000);// the granularity to which the comparison happens(the scale or level of detail in a set of data.)Range-100-1200

        Hashtable<String, Integer> box = new Hashtable<>();
        box.put("left",20);
        box.put("top",20);
        box.put("right",20);
        box.put("bottom",20);

//      output.put("boundingBox", box);
//      output.put("ignoreBox", box);

        HashMap<String, Object> sm=new HashMap<String, Object>();
        sm.put("output",output);
        sm.put("scaleToSameSize",true);//scale to same size, when baseline image and comparision image is of different size, use true

        String username = "nishantrlambdatest";
        String access_key = "x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VUI14/12");
        capabilities.setCapability("name", "Visual Ui Testing");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version","latest");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("smartUI.project","Letstry");
        capabilities.setCapability("smartUI.baseline",true);
        capabilities.setCapability("smartUI.build","10689a4");
        //capabilities.setCapability("smartUI.build","1068945");
        capabilities.setCapability("smartUI.options",sm);




        //multiple baseline images for your project
        //capabilities.setCapability("smartUI.build","build2");


        // capabilities.setCapability("geoLocation","US");
        // capabilities.setCapability("fixedIP","23.105.164.143");
        //  capabilities.setCapability("region","eu");
        driver = new RemoteWebDriver(new URL("http://nishantrlambdatest:x2qLxfUhlP4vbaXlRJVparBTDu5vdZ5KtqxPgDzDUPL1eO8yQT@hub.lambdatest.com/wd/hub"), capabilities);

        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        driver.executeScript("smartui.takeScreenshot=1");

        driver.get("https://www.lambdatest.com/");
        Thread.sleep(10000);
        driver.executeScript("smartui.takeScreenshot=2");

        driver.get("https://www.flipkart.com/");
        Thread.sleep(10000);
        driver.executeScript("smartui.takeScreenshot=3");

        driver.executeScript("lambda-status=passed");
        driver.quit();



    }
}