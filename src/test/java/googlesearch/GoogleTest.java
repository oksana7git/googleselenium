package googlesearch;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static googlesearch.CustomConditions.listNthElementHasText;
import static googlesearch.CustomConditions.sizeOf;
import static googlesearch.Tools.by;
import static googlesearch.Tools.get;
import static googlesearch.Tools.hold;
import static junit.framework.Assert.assertTrue;

public class GoogleTest {

    public static WebDriver driver = new FirefoxDriver();
    By results = by(".srg>.g");

    @BeforeClass
    public static void openPage() {
        Tools.driver = driver;
        driver.get("https://www.google.com/ncr");
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        search("selenium");
        hold().until(listNthElementHasText(results, 0, "Selenium - Web Browser Automation"));
        hold().until(sizeOf(results, 10));
        followResultLink(0);
        assertTrue(driver.getTitle().contains("Selenium - Web Browser Automation"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    public void search(String text) {
        driver.findElement(By.name("q")).sendKeys(text + Keys.ENTER);
    }

    public void followResultLink(int i) {
        get(results, i).findElement(by(".r a")).click();
    }
}
