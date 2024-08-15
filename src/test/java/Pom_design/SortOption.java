package Pom_design;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class SortOption {
    private AndroidDriver driver;

    public SortOption(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectReleaseDateSort() {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Release Date\")")).click();
    }

    public void closeFilter() {
        driver.findElement(MobileBy.AccessibilityId("Close")).click();
    }

    public String getReleaseDate(String dateText) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + dateText + "\")")).getText();
    }
}
