package ui_test.orangeHRM.ui_runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/ui_feature",
        glue = "ui_test/orangeHRM/ui_step_definitions",
        tags = "",
        dryRun = false
)
public class CukesRunner {
    
}
