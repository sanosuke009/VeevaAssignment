package Managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager extends ConfigManager{

    public synchronized WebDriver initDriver(String browser){
        this.browser = browser;
        switch (this.browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(this.getFromConfig("explicitwait"))));    
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(this.getFromConfig("explicitwait"))));
        return driver;
    }

    public synchronized void loadURL(String url){
        driver.get(url);
    }

    public synchronized void closeDriver(){
        driver.close();
    }

    public synchronized void quitDriver(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
