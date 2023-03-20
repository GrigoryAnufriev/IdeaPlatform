import models.DateTimeOfFlight;
import models.Ticket;
import models.Tickets;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        Tickets tickets = parser.parseTickets();

        if (tickets != null) {
            List<DateTimeOfFlight> dfList = new ArrayList<>();
            for (Ticket it : tickets.getTickets()) {
                if ((it.getOrigin().equals("VVO")) || (it.getDestination().equals("TLV"))) {
                    DateTimeOfFlight df = new DateTimeOfFlight(
                            it.getDeparture_date(),
                            it.getDeparture_time(),
                            it.getArrival_date(),
                            it.getArrival_time());
                    dfList.add(df);
                }

            }
            Calculate calculate = new Calculate();
            System.out.println("Average time " + calculate.avgTime(dfList));
            System.out.println("Percentile " + calculate.percentileTime(dfList, 90));

        }


    }
}
