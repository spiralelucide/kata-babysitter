import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void shouldAskBabySittingStartTime() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);

        babySitterApplication.run();

        assertThat(outputStream.toString(), containsString("Starting time: "));
    }
}