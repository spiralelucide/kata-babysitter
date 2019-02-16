import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BabySitterApplicationTest {

    @Test
    public void shouldInjectIO() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("y".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BabySitterApplication babySitterApplication = new BabySitterApplication(new PrintStream(outputStream), inputStream);
    }
}