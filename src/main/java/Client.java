import org.apache.commons.io.input.ReversedLinesFileReader;
import java.io.File;
import java.io.IOException;

public class Client {

    private static final int cpuNumber = 4;

    public static void main(String[] args) throws IOException, InterruptedException {
        String line;
        int[] cpus;
        String strpath = "path .. DataCollector01.tsv";
        while (true) {
            ReversedLinesFileReader reverseFileReader = new ReversedLinesFileReader(new File(strpath));
            line = reverseFileReader.readLine();

            String[] logLine = line.split("\\s+");
            int cpuCounter = logLine.length - 2;
            cpus = new int[cpuCounter];
            for (int i = 0; i < cpuCounter; i++) {
                cpus[i] = Math.round(Float.parseFloat(logLine[i + 2].replaceAll("\"", "")));
            }

            for (int i = 0; i < cpuCounter; i++) {
                System.out.print(cpus[i] + " ");
            }
            System.out.println();
            Thread.sleep(1000);
        }
    }
}

