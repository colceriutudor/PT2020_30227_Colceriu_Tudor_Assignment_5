package BusinessLayer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MonitoredData {
    private String startTime, endTime, activity;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public MonitoredData(String startTime, String endTime, String activity){
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }
    @Override
    public String toString() {
        return startTime + "    " + endTime + "    " + activity + "\n";
    }

    public int getDay(){
        LocalDateTime start = LocalDateTime.parse(startTime,dtf);
        return start.getDayOfMonth();
    }
    public String getActivity() {
        return this.activity;
    }
    public long getActivityTime(){
        return Date
                        .from(LocalDateTime
                                .parse(endTime,dtf)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()).getTime() -
                    Date
                        .from(LocalDateTime
                                .parse(startTime,dtf)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()).getTime();
    }
}
