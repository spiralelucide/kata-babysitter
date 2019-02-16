import model.WorkHours;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class BabySitterApplication {

    private PrintStream printStream;
    private InputStream inputStream;

    static void main(String[] args) {

    }

    BabySitterApplication(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void run() throws IOException {
        printStream.println("Starting time: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String startTime = bufferedReader.readLine();
        while(isInvalidWorkHour(startTime)) {
            printStream.println("Invalid hour please enter value between 5pm and 4am");
            printStream.println("Starting time: ");
            startTime = bufferedReader.readLine();
        }
        printStream.println("Received start time");

        printStream.println("Ending time: ");
        String endTime = bufferedReader.readLine();
        if(endTime != null && endTime.equals("y")) {
            printStream.println("Received end time");
        }

        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        if(family != null && family.equals("y")) {
            printStream.println("Received family");
        }
    }

    private boolean isInvalidWorkHour(String startTime) {
        return Arrays.stream(WorkHours.values()).noneMatch(workHours -> workHours.getHour().equals(startTime));
    }
}
