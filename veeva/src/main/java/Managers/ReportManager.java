package Managers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Bases.BaseClass;

public class ReportManager extends BaseClass {

    public void report(String message) {
        scenario.log(message);
    }

    public void attachToReport(String message, String filename) {
        scenario.attach(message, "text/plain", filename);
    }

    public void takeScreenshot() {
        byte[] sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sc, "image/png", "Screenshot");
    }

    public void takeScreenshot(String name) {
        byte[] sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sc, "image/png", name);
    }
}
