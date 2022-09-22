import file.FileFuncs;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestFileFuncs {

    //IF THIS DIFFERS FROM THE INFORMATION IN THE ACTUAL FILE THE TEST WILL FAIL
    String[] contentOfTestFile = new String[] {
            "hello",
            "",
            "test"
    };

    @Test
    void testFileRead() {
        String[] actualResult = FileFuncs.readFile("src/test/java/TestFiles/basicFile.txt");
        for (int i=0; i < contentOfTestFile.length; i++) {
            assertEquals(contentOfTestFile[i],actualResult[i]);
        }
        assertArrayEquals(contentOfTestFile,actualResult);
    }
    @Test
    void testFileReadFileNotFound() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //redirect the System-output (normaly the console) to a variable
        System.setErr(new PrintStream(outContent));

        //call your method here
        FileFuncs.readFile("src/test/java/TestFiles/basic");

        //check if your error message is in the output variable
        assertEquals("ERROR: Could not read the file or failed when reading the file, see stacktrace below\r\n", outContent.toString());
    }
}
