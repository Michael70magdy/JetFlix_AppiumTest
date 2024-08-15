package Pom_design;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getMovieTitle(String movieTitle) {
        WebElement titleElement = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + movieTitle + "\")"));
        return titleElement.getText();
    }

    public void clickMovie(String movieTitle) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + movieTitle + "\")")).click();
    }

    public void clickGoBack() {
        driver.findElement(MobileBy.AccessibilityId("Go Back")).click();
    }

    public void clickFilterAndSort() {
        driver.findElement(MobileBy.AccessibilityId("Filter & Sort Movies")).click();
    }
}
