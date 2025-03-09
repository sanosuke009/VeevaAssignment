package AtomicMethods;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Managers.DriverManager;

public class ElementActions extends DriverManager{

    public boolean doesExist(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    public boolean doesExist(WebElement el, By locator){
        return !el.findElements(locator).isEmpty();
    }

    public int numberOf(By locator){
        return driver.findElements(locator).size();
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public List<WebElement> getElements(WebElement el, By locator){
        return el.findElements(locator);
    }

    public boolean waitToBeVisible(By locator){
        boolean res = false;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            res = true;
        } catch (Exception e) {
            report("Element not visible: " + locator);
            takeScreenshot("Element not visible: " + locator);
        }
        return res;
    }

    public boolean waitToBeClickable(By locator){
        boolean res = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            res = true;
        } catch (Exception e) {
            report("Element not clickable: " + locator);
            takeScreenshot("Element not clickable: " + locator);
        }
        return res;
    }

    public String getText(By locator){
        String text = "";
        try {
            text = driver.findElement(locator).getText();
        } catch (Exception e) {
            report("Element not found: " + locator);
            takeScreenshot("Element not found: " + locator);
        }
        return text;
    }

    public String getText(WebElement el, By locator){
        String text = "";
        try {
            List<WebElement> els = el.findElements(locator);
            if(els.isEmpty())
                return text;
            text = el.findElement(locator).getText();
        } catch (Exception e) {
            report("Element not found: " + locator);
            takeScreenshot("Element not found: " + locator);
        }
        return text;
    }

    public boolean click(By locator){
        boolean res = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            res = true;
        } catch (Exception e) {
            report("Element not clickable: " + locator);
            takeScreenshot("Element not clickable: " + locator);
        }
        return res;
    }

    public boolean scrollToElement(By locator){
        boolean res = false;
        try {
            WebElement el = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Object view = js.executeScript("arguments[0].scrollIntoView"
					+ "({behavior: \"smooth\", block: \"center\", inline: \"nearest\"})", el);
            res = view != null;
        } catch (Exception e) {
            report("Element not scrolled to: " + locator);
            takeScreenshot("Element not scrolled to: " + locator);
        }
        return res;
    }

    public boolean hover(By locator){
        boolean res = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement el = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(el).build().perform();
            res = true;
        } catch (Exception e) {
            report("Element not hovered on: " + locator);
            takeScreenshot("Element not hovered on: " + locator);
        }
        return res;
    }

    public boolean hoverAndClickSubMenu(By locator, By subLocator){
        boolean res = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement el = driver.findElement(locator);
            WebElement subEl = driver.findElement(subLocator);
            Actions actions = new Actions(driver);
            actions.moveToElement(el);
            takeScreenshot("Hovered mouse on: " + locator);
            actions.moveToElement(subEl);
            takeScreenshot("Hovered mouse on: " + subLocator);
            actions.click().build().perform();
            res = true;
        } catch (Exception e) {
            report("Element not hovered on: : " + locator);
            takeScreenshot("Element not hovered on: : " + locator);
        }
        return res;
    }

    public boolean setDefaultWindow(){
        boolean res = false;
        try {
            defaultWindow = driver.getWindowHandle();
            res = true;
        } catch (Exception e) {
            report("Unable to set default window");
            takeScreenshot("Unable to set default window");
        }
        return res;
    }

    public boolean switchToNewWindow(){
        boolean res = false;
        Set<String> windows = driver.getWindowHandles();
        try {
            for (String window : windows) {
                if (!window.equals(defaultWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            res = true;
        } catch (Exception e) {
            report("Unable to switch to new window");
            takeScreenshot("Unable to switch to new window");
        }
        return res;
    }

    public boolean switchToDefaultWindow(){
        boolean res = false;
        try {
            driver.switchTo().window(defaultWindow);
            res = true;
        } catch (Exception e) {
            report("Unable to switch to default window");
            takeScreenshot("Unable to switch to default window");
        }
        return res;
    }
}
