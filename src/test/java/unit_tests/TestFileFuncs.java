package unit_tests;

import file.FileFuncs;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestFileFuncs {

    //IF THIS DIFFERS FROM THE INFORMATION IN THE ACTUAL FILE THE TEST WILL FAIL
    String[] contentOfTestFile = new String[] {
            "hello",
            "",
            "test"
    };

    @Test
    void testFileRead() {
        String[] actualResult = FileFuncs.readFile("src/test/java/unit_tests/DummyFiles/basicFile.txt");
        for (int i=0; i < contentOfTestFile.length; i++) {
            assertEquals(contentOfTestFile[i],actualResult[i]);
        }
        assertArrayEquals(contentOfTestFile,actualResult);
    }
    @Test
    void testFileReadFileNotFound() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //redirect the System-output to the variable outContent
        System.setErr(new PrintStream(outContent));

        FileFuncs.readFile("src/test/java/DummyFiles/basic");

        String actualOutput = outContent.toString().split("\n")[0];
        String filterWindows = actualOutput.split("\r")[0];
        assertEquals("ERROR: Could not read the file or failed when reading the file, see stacktrace below", filterWindows);
    }
}
