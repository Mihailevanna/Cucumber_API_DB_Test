package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature/_04_Add User Functinality.feature",
        glue = "Step_Definitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class _04_AddUserFunction extends AbstractTestNGCucumberTests {
}
