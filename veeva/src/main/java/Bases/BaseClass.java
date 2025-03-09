package Bases;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class BaseClass {

    protected Properties prop = new Properties();
    protected InputStream inputstream;
    protected Scenario scenario;
    protected String browser;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;
    protected String currentWindow;
    protected String defaultWindow;

}
