import com.beust.ah.A;
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

    @Test
    public  void subNumbers(){
        WebElement number1= driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7"));
        number1.click();

        driver.findElement((AppiumBy.accessibilityId("minus"))).click();

        WebElement number2 = driver.findElement((AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.calculator2:id/digit_2\")")));
        number2.click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        WebElement result = driver.findElement(AppiumBy.id("com.android.calculator2:id/formula"));
        String finalResult =result.getText();

        if(finalResult.equals("5")){
            System.out.println("Test is Successfully Passed");
        }else {
            System.out.println("Test is Failed");
        }



    }

    @Test
    public void multiNumbers(){
        WebElement number1 = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_4"));
        number1.click();

        driver.findElement(AppiumBy.accessibilityId("times")).click();

        WebElement number2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.calculator2:id/digit_5\")"));
        number2.click();

        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();

        WebElement result =driver.findElement(AppiumBy.className("android.widget.EditText"));

        String finalResult = result.getText();

        if(finalResult.equals("20")){
            System.out.println("Test is Passed and the final answer is " + finalResult);
        }else{
            System.out.println("Test is Failed");
        }

    }
    @Test
    public  void divNumbers(){
        WebElement number1 = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_8"));
        number1.click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();

        WebElement number2 = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_4"));
        number2.click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        WebElement result =driver.findElement(AppiumBy.className("android.widget.EditText"));

        String finalResult = result.getText();

        if(finalResult.equals("2")){
            System.out.println("Test is Passed & the Final Result is "+ finalResult);
        }else{
            System.out.println("Test is Failed");
        }
    }
}


