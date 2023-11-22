package RunnerClasses;

import Utilities.Base_Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue = "Step_Definitions",
        tags = "@Smoke",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Smoke_Testing extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters(value = "browser")
    public void setUp(@Optional(value = "chrome") String browser){
        Base_Driver.setBrowserName(browser.toLowerCase());
    }
}

