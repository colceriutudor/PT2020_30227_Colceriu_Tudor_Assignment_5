package TaskLogic;

import BusinessLayer.MonitoredData;
import FileProcessor.FileParser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    public Task6() throws Exception {
        List<MonitoredData> dataList = new FileParser().readInput();
        List<String> task6List = new ArrayList<>();
        FileWriter fw = new FileWriter("task_6.txt");
        Map<String,Integer> allTimeMap =
                dataList.stream()
                        .collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.summingInt(x -> 1)));
        Map<String, Integer> under5Map =
                dataList.stream().filter(element -> element.getActivityTime() <= 300000)
                        .collect(Collectors.groupingBy
                                (MonitoredData::getActivity,
                                        Collectors.summingInt(x -> 1)));

        under5Map.forEach((key1, value1) -> {
            if (!(task6List.contains(key1)) && (double) value1 / allTimeMap.get(key1) >= 0.9) {
                task6List.add(key1); }});


        task6List.forEach(element -> {
            try { fw.write(element); }
            catch (IOException e) { e.printStackTrace();
            }});
        fw.close();
    }
}
