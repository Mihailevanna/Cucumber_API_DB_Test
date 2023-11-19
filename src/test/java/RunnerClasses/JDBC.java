package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/Feature/JDBC/JDBC.feature",
        glue = "JDBC_StepsDefinition",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class JDBC extends AbstractTestNGCucumberTests {
}
