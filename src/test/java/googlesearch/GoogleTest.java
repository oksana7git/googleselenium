package googlesearch;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import static googlesearch.CustomConditions.listNthElementHasText;
import static googlesearch.CustomConditions.sizeOf;
import static googlesearch.Tools.*;
import static junit.framework.Assert.assertTrue;

public class GoogleTest {

    @BeforeClass
    public static void openPage() {
        setWebDriver(new FirefoxDriver());
        open("https://www.google.com/ncr");
    }

    @Test
    public void testGoogleSearch() {
        search("selenium");
        hold().until(listNthElementHasText(results, 0, "Selenium - Web Browser Automation"));
        hold().until(sizeOf(results, 10));
        followResultLink(0);
        assertTrue(getTitle().contains("Selenium - Web Browser Automation"));
    }

    @AfterClass
    public static void tearDown() {
        getWebDriver().quit();
    }

    By results = by(".srg>.g");

    public static void search(String text) {
        find(By.name("q")).sendKeys(text + Keys.ENTER);
    }

    public void followResultLink(int i) {
        get(results, i).findElement(by(".r a")).click();
    }
}
