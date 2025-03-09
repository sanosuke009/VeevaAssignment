package StepDefs;

import org.testng.Assert;

import Bases.DependencyInjection;
import PageObjects.CP.CPHomePage;
import PageObjects.CP.MensJacketPage;
import PageObjects.CP.MensShopPage;
import PageObjects.CP.NewsAndFeaturesPage;
import PageObjects.DP2.DP2HomePage;
import TestRunner.Runner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

    DependencyInjection di;
    CPHomePage cpHomePage;
    MensShopPage mensShopPage;
    MensJacketPage mensJacketPage;
    NewsAndFeaturesPage _newsAndFeaturesPage;
    DP2HomePage dp2homepage;

    
    @Before
    public void setUp(Scenario sc){
        this.di = new DependencyInjection(sc);
        String browser = Runner.BROWSER;
        System.out.println("Inside set up Browser: " + browser);
        this.di.initDriver(browser);
    }

    @After
    public void tearDown(){
        this.di.quitDriver();
    }

    @Given("the Central Product homepage is displayed")
    public void the_central_product_homepage_is_displayed() {
        this.di.loadURL(this.di.getFromConfig("cpurl"));
        this.cpHomePage = new CPHomePage(this.di);
        Assert.assertTrue(this.cpHomePage.verifyHomePage());
    }

    @When("the user navigates to Shop Menu >> Men’s")
    public void the_user_navigates_to(){
        this.mensShopPage = this.cpHomePage.navigateToMensShopMenu();
        Assert.assertNotNull(this.mensShopPage);
    }

    @Then("the user should be able to filter the list with jackets")
    public void the_user_should_be_able_to_see_the_list_of_jackets() {
        Assert.assertTrue(this.mensShopPage.verifyMensShopMenu());
        this.mensJacketPage = this.mensShopPage.selectJacket();
        Assert.assertNotNull(this.mensJacketPage);
    }

    @And("the user should be able to store the details of all jackets")
    public void the_user_should_be_able_to_store_the_details_of_all_jackets() {
        Assert.assertTrue(this.mensJacketPage.verifyMensJacketPage());
        Assert.assertTrue(this.mensJacketPage.storeJacketDetails());
    }

    @When("the user navigates to Menu Item >> click on New & Features")
    public void the_user_navigates_to_news_features(){
        this._newsAndFeaturesPage = this.cpHomePage.navigateToNewsAndFeaturesPage();
        Assert.assertNotNull(this._newsAndFeaturesPage);
    }

    @Then("the user should be able to count the number of video feeds")
    public void the_user_should_be_able_to_count_the_videos() {
        Assert.assertEquals(this._newsAndFeaturesPage.countTotalNumberOfVideos(), 21);
    }
    
    @And("the user should be able to count the number of video feeds present in the page >= 3d")
    public void the_user_should_be_able_to_count_the_videos_more_than_three_days() {
        Assert.assertEquals(this._newsAndFeaturesPage.countTotalNumberOfVideosMoreThanThreeDaysOld(), 0);
    }    

    @Given("the Second Derived Product homepage is displayed")
    public void the_derived_product_homepage_is_displayed() {
        this.di.loadURL(this.di.getFromConfig("dp2url"));
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
