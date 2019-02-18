import data.Family;
import data.SchedulableHours;
import model.BabySitter;
import org.junit.Test;
import testutil.TestInputOutput;
import testutil.UserInput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BabySitterApplicationTest {

    private UserInput.UserInputBuilder defaultUserInput = UserInput.defaultValues();

    @Test
    public void shouldInjectIO() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        new BabySitterApplication(new PrintStream(outputStream), inputStream);
    }

    @Test
    public void shouldPromptUserForStartTime() throws IOException {
        String userInput = defaultUserInput.build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Starting time: "));
    }

    @Test
    public void shouldTakeValidUserInputForStartTime() throws IOException {
        List<TestInputOutput> inputOutputs = new ArrayList<>();

        for(SchedulableHours hour : SchedulableHours.values()) {
            if(!hour.equals(SchedulableHours.Four)) {
                String userInput = defaultUserInput.startTimeInput(hour.getHour().toString() + "\n").build().toString();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                inputOutputs.add(new TestInputOutput(inputStream, outputStream));
            }
        }

        for(TestInputOutput inputOutput : inputOutputs) {
            BabySitterApplication babySitterApplication =
                    new BabySitterApplication(new PrintStream(inputOutput.getOutputStream()), inputOutput.getInputStream());

            babySitterApplication.run();

            assertThat(inputOutput.getOutputStream().toString(), containsString("Received start time"));
        }
    }

    @Test
    public void shouldValidateUserInputFormatStartTime() throws IOException {
        String userInput = defaultUserInput.startTimeInput("y\n5:00pm\n").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Invalid time format please enter value of the form hh:mm(am|pm)"));
        assertThat(outputStream.toString(), containsString("Received start time"));
    }

    @Test
    public void shouldValidateUserInputsWorkableHourForStartTime() throws IOException {
        String userInput = defaultUserInput.startTimeInput("5:00am\n7:00pm\n").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Please enter a working hour"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldPromptUserForEndTime() throws IOException {
        String userInput = defaultUserInput.build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Ending time: "));
    }

    @Test
    public void shouldTakeValidUserInputForEndTime() throws IOException {
        List<TestInputOutput> inputOutputs = new ArrayList<>();

        for(SchedulableHours hour : SchedulableHours.values()) {
            if(!hour.equals(SchedulableHours.Five)) {
                String userInput = defaultUserInput.endTimeInput(hour.getHour().toString() + "\n").build().toString();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                inputOutputs.add(new TestInputOutput(inputStream, outputStream));
            }
        }

        for(TestInputOutput inputOutput : inputOutputs) {
            BabySitterApplication babySitterApplication =
                    new BabySitterApplication(new PrintStream(inputOutput.getOutputStream()), inputOutput.getInputStream());

            babySitterApplication.run();

            assertThat(inputOutput.getOutputStream().toString(), containsString("Received end time"));
        }
    }

    @Test
    public void shouldValidateUserInputFormatEndTime() throws IOException {
        String userInput = defaultUserInput.endTimeInput("y\n12:00am\n").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Invalid time format please enter value of the form hh:mm(am|pm)"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldValidateUserInputsWorkableHourForEndTime() throws IOException {
        String userInput = defaultUserInput.endTimeInput("5:00am\n12:00am\n").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Please enter a working hour"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldValidateThatEndTimeIsAfterStartTime() throws IOException {
        String userInput = defaultUserInput.startTimeInput("7:00pm\n").endTimeInput("5:00pm\n12:00am\n").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("End time cannot be before start time, please try again"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldPromptUserForFamilyBabySitting() throws IOException {
        String userInput = defaultUserInput.build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("For which family: "));
    }

    @Test
    public void shouldTakeValidUserInputForFamilyEachFamily() throws IOException {
        BabySitter babySitter = new BabySitter();
        Map<String, Family> families = babySitter.getFamilies();
        List<TestInputOutput> inputOutputs = new ArrayList<>();
        for(Map.Entry<String, Family> familyEntry : families.entrySet()) {
            String userInput = defaultUserInput.familyInput(familyEntry.getKey()).build().toString();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            inputOutputs.add(new TestInputOutput(inputStream,outputStream));
        }

        for(TestInputOutput inputOutput : inputOutputs) {
            BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(inputOutput.getOutputStream()), inputOutput.getInputStream());

            babySitterApplication.run();

            assertThat(inputOutput.getOutputStream().toString(), containsString("Received family"));
        }
    }

    @Test
    public void shouldValidateThatFamilyEntryMatchesBabySitterFamily() throws IOException {
        String userInput = defaultUserInput.familyInput("D\nC").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Selection does not match any families available for babysitting, please try again: "));
        assertThat(outputStream.toString(), containsString("Received family"));
    }

    @Test
    public void shouldCalculateTotalPayForNight() throws IOException {
        String userInput = defaultUserInput.startTimeInput("5:00pm\n").endTimeInput("6:00pm\n").familyInput("A").build().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Calculated total for the evening is $15"));
    }

}