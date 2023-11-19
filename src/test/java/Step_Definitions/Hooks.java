package Step_Definitions;

import Utilities.Base_Driver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

public class Hooks {


    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot) (Base_Driver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }
        Base_Driver.quitDriver();

        ExtentService.getInstance().setSystemInfo("Computer User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Tester");
        ExtentService.getInstance().setSystemInfo("Application Name", "HRM Project");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Additional line", " ");
    }

}
