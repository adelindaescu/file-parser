import org.apache.commons.io.input.ReversedLinesFileReader;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String line;
        int cpu0, cpu1, cpu2, cpu3;
        String strpath = "C:\\PerfLogs\\Admin\\CPU Utilization\\DESKTOP-AS6O85B_20160216-000005\\DataCollector01.tsv";
        while (true) {
            ReversedLinesFileReader reverseFileReader = new ReversedLinesFileReader(new File(strpath));
            line = reverseFileReader.readLine();

            String[] logLine = line.split("\\s+");
            cpu0 = Math.round(Float.parseFloat(logLine[2].replaceAll("\"", "")));
            cpu1 = Math.round(Float.parseFloat(logLine[3].replaceAll("\"", "")));
            cpu2 = Math.round(Float.parseFloat(logLine[4].replaceAll("\"", "")));
            cpu3 = Math.round(Float.parseFloat(logLine[5].replaceAll("\"", "")));
            System.out.println(cpu0 + " " + cpu1 + " " + cpu2 + " " + cpu3);
            Thread.sleep(1000);
        }
    }
}

