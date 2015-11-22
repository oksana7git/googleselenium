package googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesearch.CustomConditions.minimumSizeOf;

public class Tools {

    private static WebDriver driver;

    public static long timeout = 4;

    public static void setWebDriver(WebDriver driver) {
        Tools.driver = driver;
        driver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void open(String link) {
        driver.get(link);
    }

    public static WebDriverWait hold(){
        return new WebDriverWait(driver, timeout);
    }

    public static By by(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static WebElement get(By elements, int index) {
        return hold().until(minimumSizeOf(elements, index + 1)).get(index);
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static String getTitle() {
        return driver.getTitle();
    }
}
