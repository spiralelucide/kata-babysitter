package testutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestInputOutput {
    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;

    public TestInputOutput(ByteArrayInputStream byteArrayInputStream, ByteArrayOutputStream byteArrayOutputStream) {
        this.inputStream = byteArrayInputStream;
        this.outputStream = byteArrayOutputStream;
    }

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
