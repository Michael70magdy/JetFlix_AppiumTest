import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FullTest {

    public AndroidDriver driver;
    @Test(priority = 0)
    public void Setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        caps.setCapability(MobileCapabilityType.APP, "D:\\JetFlix_AppiumTest\\Apk\\app-debug.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("disableWindowAnimation", true);
        caps.setCapability("newCommandTimeout", 600);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        Thread.sleep(3000);
    }
    @Test(priority = 1)
    public void CheckMovieName() throws InterruptedException {
        Thread.sleep(3000);
        String title = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Deadpool & Wolverine\")")).getText();
        System.out.println(title);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Deadpool & Wolverine\")")).click();
        Thread.sleep(3000);
        String moviename = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Deadpool & Wolverine\")")).getText();
        System.out.println(moviename);
        Assert.assertEquals(title,moviename,"Expected title should be the same with the movie name");
        driver.findElement(MobileBy.AccessibilityId("Go Back")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void CheckDateSorting() throws InterruptedException {
        driver.findElement(MobileBy.AccessibilityId("Filter & Sort Movies")).click();
        Thread.sleep(300);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Release Date\")")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.AccessibilityId("Close")).click();
        Thread.sleep(3000);
        String date= driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"2031-12-17\")")).getText();
        System.out.println(date);
        LocalDate MovieDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate CurrentDate = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(CurrentDate);

        Assert.assertTrue(MovieDate.isAfter(CurrentDate),"Date Should be in the future");
    }
}
