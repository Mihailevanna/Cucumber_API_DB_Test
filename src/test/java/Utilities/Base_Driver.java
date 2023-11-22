package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Driver {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (browserName.get() == null) {
            browserName.set("chrome");
        }
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        if (threadDriver.get() == null) {
            switch (browserName.get()) {
                case "chrome":
                    threadDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;
                default:
                    threadDriver.set(new ChromeDriver());

            }



        }
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return threadDriver.get();

    }

    public static void quitDriver() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }

    }

    public static void setBrowserName(String browser){
        browserName.set(browser.toLowerCase());
    }
}

