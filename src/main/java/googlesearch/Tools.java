package googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesearch.CustomConditions.minimumSizeOf;

public class Tools {

    private static WebDriver driver;

    public static long timeout = 4;

    public static void setWebDriver(WebDriver driver) {
        Tools.driver = driver;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void open(String link) {
        driver.get(link);
        driver.manage().window().maximize();
    }

    public static WebDriverWait hold(){
        return new WebDriverWait(driver, timeout);
    }

    public static By by(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static void search(String text) {
        driver.findElement(By.name("q")).sendKeys(text + Keys.ENTER);
    }

    public static WebElement get(By elements, int index) {
        return hold().until(minimumSizeOf(elements, index + 1)).get(index);
    }

    public static void followResultLink(int i, By results) {
        get(results, i).findElement(by(".r a")).click();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }
}
