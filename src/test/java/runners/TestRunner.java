package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        dryRun = true,
        tags = "@no_id",
        plugin = {"pretty", "html:target/report.html"}
)

public class TestRunner {
}
