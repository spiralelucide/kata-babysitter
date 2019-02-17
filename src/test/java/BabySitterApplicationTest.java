import model.TestInputOutput;
import model.SchedulableHours;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BabySitterApplicationTest {

    @Test
    public void shouldInjectIO() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);
    }

    @Test
    public void shouldPromptUserForStartTime() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Starting time: "));
    }

    @Test
    public void shouldTakeValidUserInputForStartTime() throws IOException {
        List<TestInputOutput> inputOutputs = new ArrayList<>();

        for(SchedulableHours hour : SchedulableHours.values()) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream((hour.getHour().toString() + "\n12:00am").getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            inputOutputs.add(new TestInputOutput(inputStream,outputStream));
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream("y\n5:00pm\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Invalid hour please enter value of the form hh:mm(am|pm)"));
        assertThat(outputStream.toString(), containsString("Received start time"));
    }

    @Test
    public void shouldValidateUserInputsWorkableHourForStartTime() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00am\n7:00pm\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Please enter a working hour"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldPromptUserForEndTime() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Ending time: "));
    }

    @Test
    public void shouldTakeValidUserInputForEndTime() throws IOException {
        List<TestInputOutput> inputOutputs = new ArrayList<>();

        for(SchedulableHours hour : SchedulableHours.values()) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(("5:00pm\n" + hour.getHour().toString()).getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            inputOutputs.add(new TestInputOutput(inputStream,outputStream));
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\ny\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Invalid hour please enter value of the form hh:mm(am|pm)"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldValidateUserInputsWorkableHourForEndTime() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\n5:00am\n12:00am".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Please enter a working hour"));
        assertThat(outputStream.toString(), containsString("Received end time"));
    }

    @Test
    public void shouldPromptUserForFamilyBabySitting() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\n12:00am\ny".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("For which family: "));
    }

    @Test
    public void shouldTakeUserInputForFamily() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5:00pm\n12:00am\ny".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Received family"));
    }
}