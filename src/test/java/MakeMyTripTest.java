package test.java;

import main.java.events.ItineraryPage;
import main.java.events.MMTHomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class MakeMyTripTest extends BaseTest{

    MMTHomePage home = new MMTHomePage();
    ItineraryPage itenerary = new ItineraryPage();

    @Test
    public void mmtTestCase() throws Throwable {

        home.setSource("Bangalore");
        home.setDestination("Pune");
        home.searchFlights();

        itenerary.sortFlightsOnPrice();
        System.out.println(itenerary.selectleastDurationFlight());

    }
}
