
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features/"},
        plugin = {
                "pretty",
                "html:target/cucumber/report-html",
                "json:target/cucumber/report.json",
                "junit:target/cucumber/junit_report.xml",
                "timeline:target/cucumber/timeline"
        })
public class CucumberRunner extends AbstractTestNGCucumberTests {



    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}