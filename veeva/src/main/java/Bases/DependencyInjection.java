package Bases;

import AtomicMethods.ElementActions;
import io.cucumber.java.Scenario;

public class DependencyInjection extends ElementActions{

    public DependencyInjection(Scenario sc){
        scenario = sc;
    }
}
