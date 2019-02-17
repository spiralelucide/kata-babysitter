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

        readTime(bufferedReader, "Starting time: ", "Received start time");
        readTime(bufferedReader, "Ending time: ", "Received end time");

        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        if(family != null && family.equals("y")) {
            printStream.println("Received family");
        }
    }

    private String readTime(BufferedReader bufferedReader, String s, String s2) throws IOException {
        printStream.println(s);
        String time = bufferedReader.readLine();
        while (isInvalidWorkHour(time)) {
            printStream.println("Invalid hour please enter value between 5:00pm and 4:00am");
            printStream.println(s);
            time = bufferedReader.readLine();
        }
        printStream.println(s2);
        return time;
    }

    private boolean isInvalidWorkHour(String time) {
        if(time.matches(WorkHour.LOCAL_TIME_PATTERN)) {
            String[] split = time.split(":");
            Hour hour = new Hour(Integer.valueOf(split[0]));
            return !babySitter.getWorkHours().contains(hour);
        }
        return true;
    }

}
