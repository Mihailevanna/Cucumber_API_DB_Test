package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature/_05_Navigation.feature",
        glue = "Step_Definitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _05_Navigation extends AbstractTestNGCucumberTests {
}
