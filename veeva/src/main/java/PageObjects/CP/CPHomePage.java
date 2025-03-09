package PageObjects.CP;

import org.openqa.selenium.By;

import Bases.DependencyInjection;

public class CPHomePage {

    DependencyInjection di;
    public CPHomePage(DependencyInjection di) {
        this.di = di;
    }

    //Page Locators
    protected By xpath_button_alert_decline = By.xpath("//button[@id='onetrust-reject-all-handler']");
    protected By xpath_button_alert_x = By.xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer' and text()='x']");
    protected By xpath_button_shop = By.xpath("//a[@rel='noreferrer']/span[text()='Shop']");
    protected By xpath_button_submenu_mens = By.xpath("(//a[contains(@title,'Men') and contains(text(),'Men')])[1]");
    protected By xpath_button_three_dots = By.xpath("(//span[text()='...'])[1]");
    protected By xpath_button_submenu_newsandfeatures = By.xpath("(//a[contains(@title,'News & Features') and contains(text(),'News & Features')])[1]");


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
        if (waitForThePresaleTicketAlert()) {
            this.di.takeScreenshot("The presale ticket alert is this.displayed");
            if (closeThePresaleTicketAlert()) {
                this.di.report("The presale ticket alert is closed");
            }
        }
        else {
            this.di.takeScreenshot("The presale ticket alert is not this.displayed");
        }
        if (this.di.waitToBeVisible(this.xpath_button_shop)) {
            this.di.takeScreenshot("The home page is this.displayed");
            res = true;
        }
        else {
            this.di.takeScreenshot("The home page is not this.displayed");
        }
        return res;
    }

    public MensShopPage navigateToMensShopMenu() {
        if (this.di.waitToBeVisible(this.xpath_button_shop)) {
            if (this.di.hoverAndClickSubMenu(this.xpath_button_shop, this.xpath_button_submenu_mens)) {
                this.di.setDefaultWindow();
                this.di.switchToNewWindow();
                this.di.takeScreenshot("Navigated to Shop >> Men's");
                return new MensShopPage(this.di);
            }
        }
        return null;
    }

    public NewsAndFeaturesPage navigateToNewsAndFeaturesPage() {
        if (this.di.waitToBeVisible(this.xpath_button_shop)) {
            if (this.di.hoverAndClickSubMenu(this.xpath_button_three_dots, this.xpath_button_submenu_newsandfeatures)) {
                this.di.takeScreenshot("Navigated to Menu Item >> New & Features");
                return new NewsAndFeaturesPage(this.di);
            }
        }
        return null;
    }

}
