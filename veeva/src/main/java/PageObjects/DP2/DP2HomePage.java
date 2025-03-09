package PageObjects.DP2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.DependencyInjection;

public class DP2HomePage {

    DependencyInjection di;
    StringBuilder sb;

    public DP2HomePage(DependencyInjection di) {
        this.di = di;
        this.sb = new StringBuilder();
    }

    //Page Locators
    protected By xpath_button_alert_decline = By.xpath("//button[@id='onetrust-reject-all-handler']");
    protected By xpath_button_alert_x = By.xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer' and text()='x']");
    protected By xpath_button_shop = By.xpath("//a[@rel='noreferrer']/span[text()='Shop']");
    protected By xpath_h3_footer = By.xpath("//h3[contains(text(),'Connect')]");
    protected By xpath_link_fooler_links = By.xpath("//footer/descendant::div[contains(@class,'flex flex-col justify-between')]/descendant::a");

    //Page Methods
    public boolean waitForTheTrackingAlert() {
        return this.di.waitToBeVisible(this.xpath_button_alert_decline);
    }

    public boolean xpath_button_alert_declineTheTrackingAlert() {
        return this.di.click(this.xpath_button_alert_decline);
    }

    public boolean waitForThePresaleTicketAlert() {
        return this.di.waitToBeVisible(this.xpath_button_alert_x);
    }

    public boolean closeThePresaleTicketAlert() {
        return this.di.click(this.xpath_button_alert_x);
    }

    public boolean verifyHomePage() {
        boolean res = false;
        if (this.di.waitToBeVisible(this.xpath_button_shop)) {
            this.di.takeScreenshot("The home page is this.displayed");
            res = true;
        }
        else {
            this.di.takeScreenshot("The home page is not this.displayed");
        }
        return res;
    }

    public boolean scrollToTheFooter(){
        this.di.scrollToElement(this.xpath_h3_footer);
        this.di.takeScreenshot("The page is scrolled to the footer.");
        return true;
    }

    public boolean storeFooterHyperlinks(){
        List<WebElement> links = this.di.getElements(this.xpath_link_fooler_links);
        Set<String> linkset = new HashSet<>();
        for (WebElement link : links) {
            String hyperlink = link.getDomAttribute("href");
            String linkname = link.getText();
            String baseurl = this.di.getFromConfig("dp2baseurl");
            String totalurl = baseurl + hyperlink;
            if(linkset.contains(hyperlink))
            {
                this.di.report("The hyperlink of "+linkname+" : "+totalurl+" is a duplicate.");
            }
            else{
                linkset.add(hyperlink);
            }
            this.sb.append("The hyper link of ");
            this.sb.append(linkname);
            this.sb.append(" is : ");
            this.sb.append(totalurl);
            this.sb.append(System.getProperty("line.separator"));
        }
        if(!links.isEmpty())
        {
            this.di.attachToReport(this.sb.toString(), "txt/csv", "HyperlinkDetails.csv");
            this.di.takeScreenshot("The hyperlinks are stored successfully.");
            return true;
        }
        else{
            this.di.takeScreenshot("The hyperlinks are not stored successfully.");
            return false;
        }
    }
}
