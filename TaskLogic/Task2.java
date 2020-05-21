package TaskLogic;

import BusinessLayer.MonitoredData;
import FileProcessor.FileParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
    public static int currentDay = 0;
    public static int iteration = 0;

    public Task2() throws IOException {
        List<MonitoredData> dataList = new FileParser().readInput();
        FileWriter fw = new FileWriter("task_2.txt");

        AtomicInteger distinctDays = new AtomicInteger(0);

        dataList.forEach(data -> {
            if(data.getDay() != currentDay) {
                if(iteration == 0) { currentDay = data.getDay(); iteration = 1; }
                distinctDays.getAndIncrement();
                currentDay = data.getDay();
            }
        });
        fw.write(distinctDays.toString());
        fw.close();
    }
}
