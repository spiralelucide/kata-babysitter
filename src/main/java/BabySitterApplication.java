import model.BabySitter;
import model.Hour;
import model.WorkHour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BabySitterApplication {

    private PrintStream printStream;
    private InputStream inputStream;
    BabySitter babySitter = new BabySitter();

    static void main(String[] args) {

    }

    BabySitterApplication(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void run() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        printStream.println("Starting time: ");
        String startTime = bufferedReader.readLine();
        while(isInvalidWorkHour(startTime)) {
            printStream.println("Invalid hour please enter value between 5:00pm and 4:00am");
            printStream.println("Starting time: ");
            startTime = bufferedReader.readLine();
        }
        printStream.println("Received start time");

        printStream.println("Ending time: ");
        String endTime = bufferedReader.readLine();
        while(isInvalidWorkHour(endTime)) {
            printStream.println("Invalid hour please enter value between 5:00pm and 4:00am");
            printStream.println("Ending time: ");
            endTime = bufferedReader.readLine();
        }
        printStream.println("Received end time");

        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        if(family != null && family.equals("y")) {
            printStream.println("Received family");
        }
    }

    private boolean isInvalidWorkHour(String startTime) {
        if(startTime.matches(WorkHour.LOCAL_TIME_PATTERN)) {
            String[] split = startTime.split(":");
            Hour hour = new Hour(Integer.valueOf(split[0]));
            return !babySitter.getWorkHours().contains(hour);
        }
        return true;
    }

}
