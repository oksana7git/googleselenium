package googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> sizeOf(final By results, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;

            public Boolean apply(WebDriver driver) {
                listSize = driver.findElements(results).size();
                return listSize == expectedSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n to be: %s\n while actual size is: %s\n", results, expectedSize, listSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(
            final By results, final int nth, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            private String actualText = "";

            public Boolean apply(WebDriver driver) {
                try {
                    actualText = driver.findElements(results).get(nth).getText();
                    return actualText.contains(expectedText);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            public String toString() {
                return String.format(
                        "\ntext: %s \n to be present in %sth element\n of list: %s\n while actual text: %s",
                        expectedText, nth, results, actualText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> minimumSizeOf(final By elementsLocator, final int expectedMinimumSize) {
        return new ExpectedCondition<List<WebElement>>() {

        public List<WebElement> apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(elementsLocator);
                if (elements.size() >= expectedMinimumSize) {
                    return elements;
                } else {
                    return null;
                }
            }
        };
    }
}
