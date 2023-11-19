package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.List;


public class My_Methods {
    public WebDriverWait wait = new WebDriverWait(Base_Driver.getDriver(), Duration.ofSeconds(10));

    public void clickMethod(WebElement element) {
        waitUntilClickable(element);
        element.click();

    }


    public void sendKeysMethod(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }


    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForNumberOfElements(By locator) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Base_Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);

    }


    public void clearText(WebElement element) {
        waitUntilVisible(element);
        element.clear();
    }


    public void actionClick(WebElement element) {
        Actions actions = new Actions(Base_Driver.getDriver());
        waitUntilClickable(element);
        actions.click(element).build();
        actions.perform();

    }

    public void uploadPic(String imagePath) {
        File file = new File(imagePath);
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        Set<String> windowHandle = Base_Driver.getDriver().getWindowHandles();
        for (String handle : windowHandle) {
            Base_Driver.getDriver().switchTo().window(handle);
            if (Base_Driver.getDriver().getTitle().contains("Upload")) {
                break;
            }
        }
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void assertTextContains(List<WebElement> elements, List<String> expectedTexts) {

        for (int i = 0; i < elements.size(); i++) {
            if (!elements.get(i).getText().contains(expectedTexts.get(i))) {
                throw new AssertionError(" mismatch ");
            }
        }
    }
}

