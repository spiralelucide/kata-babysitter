import model.BabySitter;
import model.Hour;
import model.WorkHour;
import model.WorkNight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class BabySitterApplication {

    private PrintStream printStream;
    private InputStream inputStream;
    private BabySitter babySitter = new BabySitter();

    static void main(String[] args) {

    }

    BabySitterApplication(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void run() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        WorkNight workNight = new WorkNight();

        WorkHour startHour = readWorkHour(bufferedReader, "Starting time: ", "Received start time");
        while(isInvalidWorkHour(startHour, babySitter.getWorkHours())) {
            printStream.println("Please enter a working hour");
            startHour = readWorkHour(bufferedReader, "Starting time: ", "Received start time");
        }
        workNight.setStartTime(startHour);

        WorkHour endHour = readWorkHour(bufferedReader, "Ending time: ", "Received end time");
        while(isInvalidWorkHour(endHour, babySitter.getWorkHours()) || isEndTimeBeforeStartTime(workNight.getStartTime(), endHour)) {
            if(isInvalidWorkHour(endHour,babySitter.getWorkHours())) {
                printStream.println("Please enter a working hour");
            } else {
                printStream.println("End time cannot be before start time, please try again");
            }
            endHour = readWorkHour(bufferedReader, "Ending time: ", "Received end time");
        }
        workNight.setEndTime(endHour);

        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        if(family != null && family.equals("y")) {
            printStream.println("Received family");
        }
    }

    private WorkHour readWorkHour(BufferedReader bufferedReader, String promptMessage, String successMessage) throws IOException {
        printStream.println(promptMessage);
        String time = bufferedReader.readLine();
        while (isInvalidTimeFormat(time)) {
            printStream.println("Invalid hour please enter value of the form hh:mm(am|pm)");
            printStream.println(promptMessage);
            time = bufferedReader.readLine();
        }
        printStream.println(successMessage);
        return new WorkHour(time);
    }

    private boolean isEndTimeBeforeStartTime(WorkHour startTime, WorkHour endHour) {
        return endHour.isBefore(startTime);
    }

    private boolean isInvalidWorkHour(WorkHour workHour, List<Hour> workHours) {
        return !workHours.contains(workHour);
    }

    private boolean isInvalidTimeFormat(String time) {
        return !time.matches(WorkHour.LOCAL_TIME_PATTERN);
    }

}
