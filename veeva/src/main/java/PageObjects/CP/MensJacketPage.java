package PageObjects.CP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.DependencyInjection;

public class MensJacketPage {

    DependencyInjection di;
    StringBuilder sb;
    public MensJacketPage(DependencyInjection di) {
        this.di = di;
        this.sb = new StringBuilder();
    }

    //Page Locators
    protected By xpath_breadcrumb_mensjacketpage_text = By.xpath("//span[text()='Golden State Warriors Men Jackets']");
    protected By xpath_button_nextpage = By.xpath("(//li[@class = 'next-page'])[1]");
    protected By xpath_button_nextpage_disabled = By.xpath("(//li[@class = 'next-page disabled'])[1]");
    protected By xpath_text_itemcount(String count){ return By.xpath("//div[@data-talos='itemCount' and contains(text(),'"+count+"')]");}
    protected By xpath_div_jacket_list = By.xpath("//div[@class='product-card row']");
    protected By xpath_div_jacket_title=By.xpath("./div[2]/div[2]/a");
    protected By xpath_div_jacket_price=By.xpath("./div[2]/div[1]/div/div/div[1]/span/span/span[1]/span[1]");
    protected By xpath_div_jacket_numofdivs=By.xpath("./div[2]/div");
    protected By xpath_div_jacket_top_seller_message_part1=By.xpath("./div[2]/div[3]/div/span/span[1]");
    protected By xpath_div_jacket_top_seller_message_part2=By.xpath("./div[2]/div[3]/div/span/span[2]");
    
    //Page Methods
    public boolean verifyMensJacketPage() {
        boolean res = false;
        if (this.di.waitToBeVisible(this.xpath_breadcrumb_mensjacketpage_text)) {
            this.di.takeScreenshot("The Mens Jacket Page is displayed");
            this.di.report("The Mens Jacket Page is displayed");
            res = true;
        }
        else{
            this.di.takeScreenshot("The Mens Jacket Page is not displayed");
            this.di.report("The Mens Jacket Page is not displayed");
        }
        return res;
    }

    public boolean storeJacketDetails() {
        boolean res = false;
        if (this.di.waitToBeVisible(this.xpath_div_jacket_list)) {
            int sum = 0;
            while (true) {
                int count = this.di.numberOf(this.xpath_div_jacket_list);
                List<WebElement> jackets = this.di.getElements(this.xpath_div_jacket_list);
                this.di.takeScreenshot();
                sum += count;
                String nextcount = String.valueOf(sum + 1);
                for (WebElement jacket : jackets) {
                    String title = this.di.getText(jacket, this.xpath_div_jacket_title);
                    String price = this.di.getText(jacket, this.xpath_div_jacket_price);
                    String topSellerMessagePart1 = "";
                    String topSellerMessagePart2 = "";
                    int sizeofdivs = this.di.getElements(jacket, this.xpath_div_jacket_numofdivs).size();
                    if (sizeofdivs == 3) {
                        topSellerMessagePart1 = this.di.getText(jacket, this.xpath_div_jacket_top_seller_message_part1);
                        topSellerMessagePart2 = this.di.getText(jacket, this.xpath_div_jacket_top_seller_message_part2);
                    }
                    this.sb.append("Jacket Title: ");
                    this.sb.append(title);
                    this.sb.append(" ");
                    this.sb.append("Jacket Price: ");
                    this.sb.append(price);
                    this.sb.append(" ");
                    
                    this.sb.append("Top Seller Message: ");
                    this.sb.append(topSellerMessagePart1);
                    this.sb.append(" ");
                    this.sb.append(topSellerMessagePart2);
                    this.sb.append(System.getProperty("line.separator"));
                }
                if (this.di.doesExist(this.xpath_button_nextpage)) {
                    this.di.click(this.xpath_button_nextpage);
                    this.di.waitToBeVisible(this.xpath_text_itemcount(nextcount));
                }
                else {
                    break;
                }
                
            }
            this.di.report(this.sb.toString());
            this.di.attachToReport(this.sb.toString(), "JacketDetails.txt");
            res = true;
        }
        else{
            this.di.takeScreenshot("The Jackets list is not displayed");
            this.di.report("The Jackets list is not displayed");
        }
        return res;
    }

}
