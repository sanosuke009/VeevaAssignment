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
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                this.driver = new EdgeDriver();
                break;
            case "ie":
                this.driver = new InternetExplorerDriver();
                break;
            default:
                this.driver = new ChromeDriver();
                break;
        }
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(this.getFromConfig("explicitwait"))));    
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(this.getFromConfig("explicitwait"))));
        return this.driver;
    }

    public synchronized WebDriver initDriver(){
        return initDriver(this.browser);
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
        return this.driver;
    }

    public void setBrowser(String browser){
        this.browser = browser;
    }

    public String getBrowser(){
        return this.browser;
    }
}
