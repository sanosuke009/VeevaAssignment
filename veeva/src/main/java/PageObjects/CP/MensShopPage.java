package PageObjects.CP;

import org.openqa.selenium.By;

import Bases.DependencyInjection;

public class MensShopPage {

    DependencyInjection di;
    public MensShopPage(DependencyInjection di) {
        this.di = di;
    }

    //Page Locators
    protected By xpath_breadcrumb_mensshoppingpage_text = By.xpath("//span[text()='Golden State Warriors Men']");
    protected By xpath_radiobutton_jacket = By.xpath("//span[text()='Jackets']");

    //Page Methods
    public boolean verifyMensShopMenu() {
        boolean res = false;
        if (this.di.waitToBeVisible(this.xpath_breadcrumb_mensshoppingpage_text)) {
            this.di.takeScreenshot("The Mens Shop Page is displayed");
            this.di.report("The Mens Shop Page is displayed");
            res = true;
        }
        else{
            this.di.takeScreenshot("The Mens Shop Page is not displayed");
            this.di.report("The Mens Shop Page is not displayed");
        }
        return res;
    }

    public MensJacketPage selectJacket() {
        if (this.di.waitToBeClickable(this.xpath_radiobutton_jacket)) {
            this.di.scrollToElement(this.xpath_radiobutton_jacket);
            this.di.takeScreenshot("The Jackets radio button is displayed");
            if (this.di.click(this.xpath_radiobutton_jacket)) {
                this.di.report("The Jackets radio button is clicked");
                return new MensJacketPage(this.di);
            }
            else{
                this.di.takeScreenshot("The Jackets radio button is not clicked");
                this.di.report("The Jackets radio button is not clicked");
            }
        }
        else{
            this.di.takeScreenshot("The Jackets radio button is not displayed");
            this.di.report("The Jackets radio button is not displayed");
        }
        return null;
    }

}
