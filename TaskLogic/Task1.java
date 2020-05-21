package TaskLogic;

import BusinessLayer.MonitoredData;
import FileProcessor.FileParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Task1 {
        public Task1() throws IOException {
            List<MonitoredData> data = new FileParser().readInput();
            FileWriter fw = new FileWriter("task_1.txt");

            data.forEach(line -> {
                try {
                    fw.write(line.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fw.close();
        }
}

