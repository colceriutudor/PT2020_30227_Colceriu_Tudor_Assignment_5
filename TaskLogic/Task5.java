package TaskLogic;

import BusinessLayer.MonitoredData;
import FileProcessor.FileParser;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {
    public Task5() throws IOException {
        List<MonitoredData> data = new FileParser().readInput();
        FileWriter fw = new FileWriter("task_5.txt");

        Map<String, Long> task5IntMap =
                data.stream()
                        .collect(Collectors.groupingBy
                                (MonitoredData::getActivity,Collectors.summingLong(MonitoredData::getActivityTime)));
        Map<String, LocalDateTime> task5Map = task5IntMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e-> new Timestamp(e.getValue()).toLocalDateTime()));
        task5Map.forEach((k,v) -> {
            try { fw.write(k + ": " + v.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n"); }
            catch (IOException e) { e.printStackTrace(); }
        });
        fw.close();
    }
}
