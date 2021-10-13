
package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
        features = "src/test/java/features/Contact.feature",
        glue = "stepDefinitions",

        //tags = "@demo",

        dryRun = false
        //monochrome = false // outputların daha okunabilir olması ıcın
)

public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {
}