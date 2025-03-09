package PageObjects.CP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.DependencyInjection;

public class NewsAndFeaturesPage {

    DependencyInjection di;
    public NewsAndFeaturesPage(DependencyInjection di) {
        this.di = di;
    }

    //Page Locators
    protected By xpath_h3_news = By.xpath("//h3[text()='NEWS']");
    protected By xpath_h3_videos = By.xpath("//h3[text()='VIDEOS']");
    protected By xpath_playbutton_video = By.xpath("//div[contains(@class,'IconPlay')]");
    protected By xpath_icon_upload_days_ago = By.xpath("//div[contains(@class,'IconPlay')]/ancestor::div[contains(@class,'TileArticle_tileArticleContent__RyqlU')]/div/descendant::time/span");

    //Page Methods
    public boolean verifyNewsAndFeaturesPage() {
        boolean res = false;
        if (this.di.waitToBeVisible(this.xpath_h3_news)) {
            this.di.takeScreenshot("The News And Features Page is displayed");
            res = true;
        }
        else{
            this.di.takeScreenshot("The News And Features Page is not displayed");
        }
        return res;
    }

    public int countTotalNumberOfVideos() {
        int res = 0;
        if (this.di.waitToBeVisible(this.xpath_h3_videos)) {
            this.di.scrollToElement(this.xpath_h3_videos);
            res = this.di.numberOf(this.xpath_playbutton_video) - 1;
            this.di.takeScreenshot("The Videos section is displayed and total number of videos is: " + res);
        }
        else{
            this.di.takeScreenshot("The Videos section is not displayed");
        }
        return res;
    }

    public int countTotalNumberOfVideosMoreThanThreeDaysOld() {
        int res = 0;
        if (this.di.waitToBeVisible(this.xpath_h3_videos)) {
            this.di.scrollToElement(this.xpath_h3_videos);
            List<WebElement> videos = this.di.getElements(this.xpath_icon_upload_days_ago);
            for (WebElement video : videos) {
                String days = video.getText().split("d")[0];
                if(!days.contains("h") && !days.contains("m"))
                {
                    if (Integer.parseInt(days) >= 3) {
                        res++;
                    }
                }
            }
            this.di.takeScreenshot("The Videos section is displayed and total number of videos more than 3 days old is: " + res);
        }
        else{
            this.di.takeScreenshot("The Videos section is not displayed");
        }
        return res;
    }

}
