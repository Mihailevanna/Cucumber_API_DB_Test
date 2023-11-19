package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/Feature/_02_Personal_Info.feature",
        glue = "Step_Definitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _02_PersonalInfo extends AbstractTestNGCucumberTests {
}


