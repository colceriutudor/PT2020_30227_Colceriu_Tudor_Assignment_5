package FileProcessor;

import BusinessLayer.MonitoredData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileParser {
    public FileParser(){};

    public List<MonitoredData> readInput() throws IOException {
        String fileName = "Activities.txt";
        List<MonitoredData> inputData = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get(fileName));
        {
            stream.map(line -> line.split("\t+"))
                    .forEach(a -> inputData.add(new MonitoredData(a[0], a[1], a[2])));
        }
        return inputData;
    }
}
