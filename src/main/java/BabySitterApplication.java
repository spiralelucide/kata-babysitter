import model.BabySitter;
import model.WorkHour;
import model.WorkNight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

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
        workNight.setStartTime(gatherStartTime(bufferedReader));
        workNight.setEndTime(gatherEndTime(bufferedReader, workNight));

        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        if(family != null && family.equals("A")) {
            printStream.println("Received family");
        }
    }

    private WorkHour gatherStartTime(BufferedReader bufferedReader) throws IOException {
        WorkHour startTime = readWorkHour(bufferedReader, "Starting time: ", "Received start time");
        while(isInvalidWorkHour(startTime)) {
            printStream.println("Please enter a working hour");
            startTime = readWorkHour(bufferedReader, "Starting time: ", "Received start time");
        }
        return startTime;
    }

    private WorkHour gatherEndTime(BufferedReader bufferedReader, WorkNight workNight) throws IOException {
        WorkHour endTime = readWorkHour(bufferedReader, "Ending time: ", "Received end time");
        while(isInvalidWorkHour(endTime) || isEndTimeBeforeStartTime(workNight.getStartTime(), endTime)) {
            if(isInvalidWorkHour(endTime)) {
                printStream.println("Please enter a working hour");
            } else {
                printStream.println("End time cannot be before start time, please try again");
            }
            endTime = readWorkHour(bufferedReader, "Ending time: ", "Received end time");
        }
        return endTime;
    }

    private WorkHour readWorkHour(BufferedReader bufferedReader, String promptMessage, String successMessage) throws IOException {
        printStream.println(promptMessage);
        String time = bufferedReader.readLine();
        while (!WorkHour.isValidTimeFormat(time)) {
            printStream.println("Invalid time format please enter value of the form hh:mm(am|pm)");
            printStream.println(promptMessage);
            time = bufferedReader.readLine();
        }
        printStream.println(successMessage);
        return new WorkHour(time);
    }

    private boolean isEndTimeBeforeStartTime(WorkHour startTime, WorkHour endTime) {
        return !WorkNight.isStartTimeBeforeEndTime(startTime, endTime);
    }

    private boolean isInvalidWorkHour(WorkHour hour) {
        return !hour.isValidWorkHour(babySitter.getWorkHours());
    }
}
