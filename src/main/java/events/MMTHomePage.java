package main.java.events;

import main.java.utils.ElementFetch;
import org.openqa.selenium.JavascriptExecutor;
import test.java.BaseTest;

public class MMTHomePage extends BaseTest {
    ElementFetch eleFetch = new ElementFetch();

    public void setSource(String source) throws Throwable {

        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        if (eleFetch.getWebElements("ID", "webklipper-publisher-widget-container-notification-close-div").size()>0){
            eleFetch.getWebElement("ID", "webklipper-publisher-widget-container-notification-close-div").click();
        }
            eleFetch.getWebElement("XPATH", "//li[@data-cy='account']").click();
            //select source
            eleFetch.getWebElement("ID", "fromCity").click();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", eleFetch.getWebElement("ID", "fromCity"));
            eleFetch.getWebElement("XPATH", "//div[@id='react-autowhatever-1']/../input").sendKeys(source);
            Thread.sleep(2000);
            eleFetch.getWebElement("ID", "react-autowhatever-1-section-0-item-0").click();

    }

    public void setDestination (String destination) throws Throwable {
        //select destination
        eleFetch.getWebElement("ID", "toCity").click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", eleFetch.getWebElement("ID", "toCity"));
        eleFetch.getWebElement("XPATH", "//div[@id='react-autowhatever-1']/../input").sendKeys(destination);
        Thread.sleep(2000);
        eleFetch.getWebElement("ID", "react-autowhatever-1-section-0-item-0").click();
    }

    public void searchFlights()throws Throwable{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", eleFetch.getWebElement("XPATH", "//a[text()='Search']"));


    }

}
