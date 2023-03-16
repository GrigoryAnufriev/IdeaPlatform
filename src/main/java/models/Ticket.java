package models;

import java.time.LocalTime;
import java.time.LocalDate;

public class Ticket {

    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private LocalDate departure_date;
    private LocalTime departure_time;
    private LocalDate arrival_date;
    private LocalTime arrival_time;
    private String carrier;
    private Integer stops;
    private Integer price;


    public Ticket(String origin, String origin_name, String destination, String destination_name, LocalDate departure_date, LocalTime departure_time, LocalDate arrival_date, LocalTime arrival_time, String carrier, Integer stops, Integer price) {
        this.origin = origin;
        this.origin_name = origin_name;
        this.destination = destination;
        this.destination_name = destination_name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }



    public String getOrigin() {
        return origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public LocalDate getArrival_date() {
        return arrival_date;
    }

    public LocalTime getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() { return carrier; }

    public Integer getStops() {
        return stops;
    }

    public Integer getPrice() {
        return price;
    }


    public void setOrigin(String origin) { this.origin = origin; }

    public void setOrigin_name(String origin_name) { this.origin_name = origin_name; }

    public void setDestination(String destination) { this.destination = destination; }

    public void setDestination_name(String destination_name) { this.destination_name = destination_name; }

    public void setDeparture_date(LocalDate departure_date) { this.departure_date = departure_date; }

    public void setDeparture_time(LocalTime departure_time) { this.departure_time = departure_time; }

    public void setArrival_date(LocalDate arrival_date) { this.arrival_date = arrival_date; }

    public void setArrival_time(LocalTime arrival_time) { this.arrival_time = arrival_time; }

    public void setCarrier(String carrier) { this.carrier = carrier; }

    public void setStops(Integer stops) { this.stops = stops; }

    public void setPrice(Integer price) { this.price = price; }
}
