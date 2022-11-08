package main.java.events;

import main.java.utils.ElementFetch;
import org.openqa.selenium.JavascriptExecutor;
import test.java.BaseTest;

public class ItineraryPage extends BaseTest {
    ElementFetch eleFetch = new ElementFetch();

    public void sortFlightsOnPrice() throws Throwable{
        if (eleFetch.getWebElement("XPATH" , "//button[text()='OKAY, GOT IT!']").isDisplayed()){
            eleFetch.getWebElement("XPATH" , "//button[text()='OKAY, GOT IT!']").click();
        }
        String chepestFlight = eleFetch.getWebElement("XPATH", "(//button[contains(@id , '_0') and contains(@class, 'ViewFareBtn')])[1]/../div/p").getText();

        eleFetch.getWebElement("XPATH", "//span[text()='Duration']").click();


    }

    public String selectleastDurationFlight() throws Throwable{
        int shortestDuration = 2460;
        String flightName = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i=1; i<8; i++) {

            String id = "flight_list_item_" +  i;

            String xpath = "//div[contains(@id, '"+id+"')]/div/div/div[2]/label/div/div/div/div[2]/p";
            String xpathOfName = "//div[contains(@id, '"+id+"')]/div/div/div/div/p[2]";
            String duartion = eleFetch.getWebElement("XPATH", xpath).getText();

            String dur = duartion.substring(0, 2) + duartion.substring(5, 7);

            int duration = Integer.parseInt(dur);

            if (duration < shortestDuration){
                shortestDuration = duration;
                flightName = eleFetch.getWebElement("XPATH" , xpathOfName).getText();
            }

            Thread.sleep(250);
            js.executeScript("window.scrollBy(0,100)", "");

        }
        return flightName;



    }

}
