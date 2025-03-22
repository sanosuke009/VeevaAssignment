package StepDefs.DP2;

import org.testng.Assert;

import Bases.DependencyInjection;
import PageObjects.DP2.DP2HomePage;
import StepDefs.Base.StepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefsDP2{

    DependencyInjection di;
    DP2HomePage dp2homepage;

    public StepDefsDP2(StepDefs stepdefs){
        this.di = stepdefs.di;
    }

    @Given("Open a browser and load the Derived Product 2 URL")
    public void open_browser_and_load_the_url() {
        this.di.initDriver();
        this.di.loadURL(this.di.getFromConfig("dp2url"));
    }

    @Given("the Second Derived Product homepage is displayed")
    public void the_derived_product_homepage_is_displayed() {
        this.dp2homepage = new DP2HomePage(this.di);
        Assert.assertTrue(this.dp2homepage.verifyHomePage());
    }

    @When("the user scrolls down to the footer")
    public void the_user_scrolls_to_footer(){
        Assert.assertTrue(this.dp2homepage.scrollToTheFooter());
    }

    @And("the user should be able to store the hyperlinks of all the links and report duplicates")
    public void the_user_should_be_able_to_store_the_footer_hyperlinks() {
        Assert.assertTrue(this.dp2homepage.storeFooterHyperlinks());
    }

}
