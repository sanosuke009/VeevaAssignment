package StepDefs.Base;

import Bases.DependencyInjection;
import TestRunner.Runner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class StepDefs {

    public DependencyInjection di;

    
    @Before
    public void setUp(Scenario sc){
        this.di = new DependencyInjection(sc);
        String browser = Runner.BROWSER;
        System.out.println("Inside set up Browser: " + browser);
        this.di.setBrowser(browser);
    }

    @After
    public void tearDown(){
        if (!(this.di.getDriver() == null)) {
            this.di.quitDriver();
        }
    }
}
