package Pom_design;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainTest {
    private AndroidDriver driver;
    private HomePage homepage;
    private SortOption sortoption;

    @BeforeClass
    public void Setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        caps.setCapability(MobileCapabilityType.APP, "D:\\JetFlix_AppiumTest\\Apk\\app-debug.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("disableWindowAnimation", true);
        caps.setCapability("newCommandTimeout", 600);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        homepage = new HomePage(driver);
        sortoption = new SortOption(driver);

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void CheckMovieName() throws InterruptedException {
        Thread.sleep(3000);
        String title = homepage.getMovieTitle("Deadpool & Wolverine");
        System.out.println(title);
        homepage.clickMovie("Deadpool & Wolverine");
        Thread.sleep(3000);
        String moviename = homepage.getMovieTitle("Deadpool & Wolverine");
        System.out.println(moviename);
        Assert.assertEquals(title, moviename, "Expected title should be the same with the movie name");
        homepage.clickGoBack();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void CheckDateSorting() throws InterruptedException {
        homepage.clickFilterAndSort();
        Thread.sleep(300);
        sortoption.selectReleaseDateSort();
        Thread.sleep(3000);
        sortoption.closeFilter();
        Thread.sleep(3000);
        String date = sortoption.getReleaseDate("2031-12-17");
        System.out.println(date);
        LocalDate MovieDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate CurrentDate = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(CurrentDate);
        Assert.assertTrue(MovieDate.isAfter(CurrentDate), "Date Should be in the future");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
