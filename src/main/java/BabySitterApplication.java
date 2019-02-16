import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

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
        String input = bufferedReader.readLine();
        if(input.equals("y")) {
            printStream.println("Took user input");
        }

        printStream.println("Ending time: ");
        input = bufferedReader.readLine();
        if(input != null && input.equals("y")) {
            printStream.println("Received End time");
        }

        printStream.println("For which family: ");
    }
}
