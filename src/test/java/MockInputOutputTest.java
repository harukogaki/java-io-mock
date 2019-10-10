import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockInputOutputTest {

    ByteArrayInputStream in;

    @Before
    public void setUp() {
        in = new ByteArrayInputStream("Jeff\n1\n".getBytes());
        System.setIn(in);
    }

    @Test
    public void shouldMockInputWithJava() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream mockOut = new PrintStream(outputStream);
        System.setOut(mockOut);

        MockInputOutput.doIt();

        String[] output = outputStream.toString().split("\n");
        System.out.println(output);

        Assert.assertEquals("Hello my name is Jeff", output[0]);
        Assert.assertEquals("Nice to meet you: 1", output[1]);
    }

    @Test
    public void shouldMockInputWithMockito() {
        PrintStream mockOutMockito = mock(PrintStream.class);
        System.setOut(mockOutMockito);

        MockInputOutput.doIt();

        verify(System.out).println("Hello my name is Jeff");
    }
}