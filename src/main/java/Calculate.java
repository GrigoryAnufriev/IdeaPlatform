import models.DateTimeOfFlight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Calculate {

    private long differenceTime(LocalDate departure_date, LocalTime departure_time, LocalDate arrival_date, LocalTime arrival_time){
        LocalDateTime dateTime_departure = departure_date.atTime(departure_time);
        LocalDateTime dateTime_arrival = arrival_date.atTime(arrival_time);


        return ChronoUnit.MINUTES.between(dateTime_departure, dateTime_arrival);
    }

    public String avgTime(List<DateTimeOfFlight> dateTimeOfFlight){
        double res = 0;
        int k = 0;
        for (DateTimeOfFlight it : dateTimeOfFlight){
            k++;
            res += differenceTime(it.getDeparture_date(), it.getDeparture_time(),
                                 it.getArrival_date(), it.getArrival_time());
        }

        res = res / k;

        return (int) res / 60 + ":" + ((int) res - (((int) res / 60) * 60));
    }

    public String percentileTime(List<DateTimeOfFlight> dateTimeOfFlight, double percentile) {

        List<Long> minutes = new ArrayList<>();
        for (DateTimeOfFlight it : dateTimeOfFlight){
            minutes.add(differenceTime(it.getDeparture_date(), it.getDeparture_time(),
                                        it.getArrival_date(), it.getArrival_time()));
        }

        minutes.sort((o1, o2) -> (int) (o1 - o2));

        int countTimes = 0;
        for (long res : minutes){
            double per = 100.0 * (++countTimes) / minutes.size();
            if (percentile <= per) {
                return (int) res / 60 + ":" + ((int) res - (((int) res / 60) * 60));
            }

        }

        return "None";

    }
}
