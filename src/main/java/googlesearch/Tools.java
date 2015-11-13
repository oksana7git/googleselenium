package googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesearch.CustomConditions.minimumSizeOf;

public class Tools {

    public static WebDriver driver;
    public static long timeout = 4;

    public static WebDriverWait hold(){
        return new WebDriverWait(driver, timeout);
    }

    public static WebElement get(By elements, int index){
        return hold().until(minimumSizeOf(elements, index + 1)).get(index);
    }

    public static By by(String cssSelector){
        return By.cssSelector(cssSelector);
    }
}
