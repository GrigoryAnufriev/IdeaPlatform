import models.Ticket;
import models.Tickets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Tickets parseTickets(){

        Tickets tickets = new Tickets();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/tickets.json")) {

            JSONObject ticketsJsonObject = (JSONObject) parser.parse(reader);
            JSONArray ticketsJsonArray = (JSONArray) ticketsJsonObject.get("tickets");

            List<Ticket> ticketList = new ArrayList<>();
            for (Object it: ticketsJsonArray) {
                JSONObject ticketJsonObject = (JSONObject) it;

                String origin = (String) ticketJsonObject.get("origin");
                String origin_name = (String) ticketJsonObject.get("origin_name");
                String destination = (String) ticketJsonObject.get("destination");
                String destination_name = (String) ticketJsonObject.get("destination_name");
                String departure_date = (String) ticketJsonObject.get("departure_date");
                String departure_time = (String) ticketJsonObject.get("departure_time");
                String arrival_date = (String) ticketJsonObject.get("arrival_date");
                String arrival_time = (String) ticketJsonObject.get("arrival_time");
                String carrier = (String) ticketJsonObject.get("carrier");
                long stops = (long) ticketJsonObject.get("stops");
                long price = (long) ticketJsonObject.get("price");

                DateTimeFormatter formatter_date = DateTimeFormatter.ofPattern("dd.MM.yy");
                DateTimeFormatter formatter_time = DateTimeFormatter.ofPattern("H:mm");

                Ticket ticket = new Ticket(origin, origin_name, destination, destination_name,
                        LocalDate.parse(departure_date, formatter_date),
                        LocalTime.parse(departure_time, formatter_time),
                        LocalDate.parse(arrival_date, formatter_date),
                        LocalTime.parse(arrival_time, formatter_time),
                        carrier, (int) stops, (int) price);

                ticketList.add(ticket);
            }

            tickets.setTickets(ticketList);
            return tickets;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
