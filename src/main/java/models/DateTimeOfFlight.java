package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeOfFlight {
    final private LocalDate departure_date;
    final private LocalTime departure_time;
    final private LocalDate arrival_date;
    final private LocalTime arrival_time;

    public DateTimeOfFlight(LocalDate departure_date, LocalTime departure_time, LocalDate arrival_date, LocalTime arrival_time) {
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
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
}
