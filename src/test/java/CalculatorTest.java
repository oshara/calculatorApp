import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest
{
    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerURL = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability( "platformName","Android");
        dc.setCapability("appium:automationName","uiautomator2");
        //dc.setCapability("appium:app","E:\\AppiumProjects\\ApiDemos-debug.apk");
        dc.setCapability("appium:appPackage","com.android.calculator2");
        dc.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        dc.setCapability("appium:noReset","true");

        driver = new AndroidDriver(new URL(appiumServerURL),dc);
    }

    @Test
public  void addTest(){

//        WebElement eightNumber =driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.calculator2:id/digit_8\")"));
//        eightNumber.click();
//        WebElement number1 =driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_8"));
//        number1.click();

        WebElement num = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.calculator2:id/digit_8\"]"));
        num.click();

        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add")).click();

        WebElement sixthNumber = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.calculator2:id/digit_6\")"));
        sixthNumber.click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        WebElement result = driver.findElement(AppiumBy.id("com.android.calculator2:id/formula"));
        String text = result.getText();
        if (text.equals("14")) {

            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }


    }



}
