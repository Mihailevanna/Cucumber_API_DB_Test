package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature/_03_EmployeePicture.feature",
        glue = "Step_Definitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class _03_EmployeePicture extends AbstractTestNGCucumberTests {
}
