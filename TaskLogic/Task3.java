package TaskLogic;

import BusinessLayer.MonitoredData;
import FileProcessor.FileParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public Task3() throws Exception{
        List<MonitoredData> data = new FileParser().readInput();
        FileWriter fw = new FileWriter("task_3.txt");

        Map<String,Integer> task3map =
                data.stream()
                .collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.summingInt(x -> 1)));
        task3map.forEach((k,v) -> {
                try { fw.write(k + ": " + v + "\n"); }
                catch (IOException e) { e.printStackTrace(); }
        });
        fw.close();
    }
}
