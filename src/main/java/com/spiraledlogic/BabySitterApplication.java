package com.spiraledlogic;

import com.spiraledlogic.data.Family;
import com.spiraledlogic.model.BabySitter;
import com.spiraledlogic.model.WorkHour;
import com.spiraledlogic.model.WorkNight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BabySitterApplication {

    private PrintStream printStream;
    private InputStream inputStream;
    private BabySitter babySitter = new BabySitter();

    public static void main(String[] args) throws IOException {
        BabySitterApplication app = new BabySitterApplication(System.out,System.in);
        app.run();
    }

    BabySitterApplication(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public void run() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            WorkNight workNight = new WorkNight();
            workNight.setStartTime(gatherStartTime(bufferedReader));
            workNight.setEndTime(gatherEndTime(bufferedReader, workNight));
            workNight.setFamily(gatherFamily(bufferedReader));

            printStream.println(String.format("Calculated total pay for the evening is $%d", workNight.calculateTotal()));
        }
    }

    private WorkHour gatherStartTime(BufferedReader bufferedReader) throws IOException {
        WorkHour startTime = readWorkHour(bufferedReader, "Starting time: ");
        while(isInvalidWorkHour(startTime)) {
            printStream.println(String.format("Please enter a time between %s and %s inclusive for starting time", "5:00pm" , "4:00am"));
            startTime = readWorkHour(bufferedReader, "Starting time: ");
        }
        printStream.println("Received start time");
        return startTime;
    }

    private WorkHour gatherEndTime(BufferedReader bufferedReader, WorkNight workNight) throws IOException {
        WorkHour endTime = readWorkHour(bufferedReader, "Ending time: ");
        while(isInvalidWorkHour(endTime) || isEndTimeBeforeStartTime(workNight.getStartTime(), endTime)) {
            if(isInvalidWorkHour(endTime)) {
                printStream.println(String.format("Please enter a time between %s and %s inclusive for ending time", "5:00pm" , "4:00am"));
            } else {
                printStream.println("End time cannot be before or the same as start time, please try again");
            }
            endTime = readWorkHour(bufferedReader, "Ending time: ");
        }
        printStream.println("Received end time");
        return endTime;
    }

    private Family gatherFamily(BufferedReader bufferedReader) throws IOException {
        printStream.println("For which family: ");
        String family = bufferedReader.readLine();
        while(!babySitter.getFamilies().containsKey(family)) {
            printStream.println(String.format("Selection does not match any families available for babysitting. The options are %s, please try again: ", babySitter.getFamilies().keySet().toString()));
            family = bufferedReader.readLine();
        }
        printStream.println("Received family");
        return babySitter.getFamilies().get(family);
    }

    private WorkHour readWorkHour(BufferedReader bufferedReader, String promptMessage) throws IOException {
        printStream.println(promptMessage);
        String time = bufferedReader.readLine();
        while (!WorkHour.isValidTimeFormat(time)) {
            printStream.println("Invalid time format please enter value of the form hh:mm(am|pm)");
            printStream.println(promptMessage);
            time = bufferedReader.readLine();
        }
        return new WorkHour(time);
    }

    private boolean isEndTimeBeforeStartTime(WorkHour startTime, WorkHour endTime) {
        return !WorkNight.isStartTimeBeforeEndTime(startTime, endTime);
    }

    private boolean isInvalidWorkHour(WorkHour hour) {
        return !hour.isValidWorkHour(babySitter.getWorkHours());
    }
}
