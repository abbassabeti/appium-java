import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(JUnit4.class)
public class JavaAppiumControlsAppSampleTest {

    private String BUNDLE_ID = "com.tricentis.NewControlsApp";
    private String APP_V1_0_0 = "/java/resources/TestApp.app";
    private By msgInput = By.xpath("//XCUIElementTypeTextField[@name=\"messageInput\"]");
    private By savedMsg = MobileBy.AccessibilityId("savedMessage");
    private By saveMsgBtn = MobileBy.AccessibilityId("messageSaveBtn");
    private By echoBox = MobileBy.AccessibilityId("Echo Box");

    @Test
    public void testControlsApp () throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //File appFile = new File("../resources/TestApp.app");

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("bundleId","com.tricentis.NewControlsApp");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("platformVersion", "15.0");
        //capabilities.setCapability("app", APP_V1_0_0);

        // Open the app.
        IOSDriver driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        try {
            long time1 = System.currentTimeMillis();
            WebElement element = driver.findElement(By.id("tabbarDisabler"));
            element.click();

            HashMap swipeObject = new HashMap();
            swipeObject.put("direction", "down");

            driver.executeScript("mobile: scroll", swipeObject);
            element = driver.findElement(By.className("XCUIElementTypeSearchField"));
            element.click();
            element.sendKeys("Hello");
            swipeObject.put("direction", "up");

            driver.executeScript("mobile: scroll", swipeObject);
//            swipeObject.put("direction", "down");
//            driver.executeScript("mobile: scroll", swipeObject);

            element = driver.findElement(By.id("tabbarDisabler"));
            element.click();
            element = driver.findElement(By.id("Controls"));
            element.click();
            element = driver.findElement(By.id("Reset"));
            element.click();
            element = driver.findElement(By.id("Enable single line"));
            element.click();
            element = driver.findElement(By.id("Enable button"));
            element.click();

            element = driver.findElement(By.id("Simple button"));
            element.click();

            element = driver.findElement(By.id("XosModules"));
            element.click();
            element = driver.findElement(By.id("com.tricentis.androidtestapp:id/xosButton"));
            element.click();
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFindByXPath () throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //File appFile = new File("../resources/TestApp.app");

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("bundleId","com.tricentis.NewControlsApp");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("platformVersion", "15.0");
        //capabilities.setCapability("app", APP_V1_0_0);

        // Open the app.
        IOSDriver driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        try {
            long time1 = System.currentTimeMillis();
            for (int j = 0; j < 50; j++) {
                WebElement element = driver.findElement(By.xpath("//XCUIElementTypeSwitch[@name=\"tabbarDisabler\"]"));
                //Assert.assertEquals(element.getClass().getName(), "XCUIElementTypeSwitch");
            }
            long time2 = System.currentTimeMillis();
            System.out.println("Find by xpath (class and id) - Time:");
            System.out.println(time2 - time1);


            long time3 = System.currentTimeMillis();
            for (int j = 0; j < 50; j++) {
                WebElement element = driver.findElement(By.id("tabbarDisabler"));
                //Assert.assertEquals(element.getClass().getName(), "XCUIElementTypeSwitch");
            }
            long time4 = System.currentTimeMillis();
            System.out.println("Find by id");
            System.out.println(time4 - time3);


            long time5 = System.currentTimeMillis();
            for (int j = 0; j < 50; j++) {
                WebElement element = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"TestApp\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]"));
                WebElement element1 = element.findElement(By.xpath("//XCUIElementTypeSwitch"));
                //Assert.assertEquals(element.getClass().getName(), "XCUIElementTypeSwitch");
            }
            long time6 = System.currentTimeMillis();
            System.out.println("Find by xpath of parent and its own class - Time:");
            System.out.println(time6 - time5);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFindById () throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //File appFile = new File("../resources/TestApp.app");

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("bundleId","com.tricentis.NewControlsApp");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("platformVersion", "15.0");
        //capabilities.setCapability("app", APP_V1_0_0);

        // Open the app.
        IOSDriver driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        try {
            long time3 = System.currentTimeMillis();
            for (int j = 0; j < 100; j++) {
                WebElement element = driver.findElement(By.id("tabbarDisabler"));
                //Assert.assertEquals(element.getClass().getName(), "XCUIElementTypeSwitch");
            }
            long time4 = System.currentTimeMillis();
            System.out.println("Find by id");
            System.out.println(time4 - time3);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFindByTypeAndId () throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //File appFile = new File("../resources/TestApp.app");

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("bundleId","com.tricentis.NewControlsApp");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("platformVersion", "15.0");
        //capabilities.setCapability("app", APP_V1_0_0);

        // Open the app.
        IOSDriver driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        try {
            long time3 = System.currentTimeMillis();
            for (int j = 0; j < 100; j++) {
                List<WebElement> element = driver.findElements(By.className("XCUIElementTypeSwitch"));//(By.id("tabbarDisabler"));
//                for (WebElement item : element) {
//                    System.out.println(item.getTagName());
//                }
                //Assert.assertEquals(element.getClass().getName(), "XCUIElementTypeSwitch");
            }
            long time4 = System.currentTimeMillis();
            System.out.println("Find by id");
            System.out.println(time4 - time3);
        } finally {
            driver.quit();
        }
    }
}
