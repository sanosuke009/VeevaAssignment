package TestRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/featurefiles/CP",
    glue = {"StepDefs"},
    plugin = {"json:Results/cucumberjson/cucumber.json"}
)
public class Runner extends AbstractTestNGCucumberTests{

    // static thread-safe container to keep the browser value
    public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();

    @BeforeTest
    @Parameters({"browser"})
    public void defineBrowser(String browser) {
        //put browser value to thread-safe container
        Runner.BROWSER.set(browser);
        System.out.println(browser);
    }
}
