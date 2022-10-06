package frontend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

class SourceTest {

    private Source source;

    @BeforeEach
    void setup() throws Exception
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("ABCDE".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        source = new Source(reader);
    }

    @Test
    void test() throws Exception
    {
        System.out.println(source.currentChar());
        System.out.println(source.nextChar());
        System.out.println(source.nextChar());
        System.out.println(source.nextChar());
        System.out.println(source.peekChar());
        System.out.println(source.currentChar());
        System.out.println(source.currentChar());
        System.out.println(source.nextChar());
        System.out.println(source.nextChar());
    }
}