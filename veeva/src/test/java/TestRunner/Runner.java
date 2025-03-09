package TestRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/featurefiles",
    glue = {"StepDefs"},
    plugin = {"json:Results/cucumberjson/cucumber.json"}
)
public class Runner extends AbstractTestNGCucumberTests{

    public static String BROWSER;

    @BeforeTest
    @Parameters({"browser"})
    public synchronized void defineBrowser(String browser) {
        Runner.BROWSER = browser;
        System.out.println(browser);
    }

    @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
