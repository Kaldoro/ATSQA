import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class TestMain {

    String[] exampleTestSmellResult = new String[] {
            "App;TestFileName;ProductionFileName;LOC;numberMethods;Assertion Roulette;Eager Test;Mystery Guest;Sleepy Test;Unknown Test;Redundant Assertion;Dependent Test;Magic Number Test;Conditional Test Logic;EmptyTest;General Fixture;IgnoredTest;Sensitive Equality;Verbose Test;Default Test;Resource Optimism;Duplicate Assert;Exception Catching Throwing;Constructor Initialization;Print Statement;Lazy Test",
            "testProject;testFile1;file1;50;16;8;0;0;0;0;0;8;0;0;0;0;0;0;0;0;0;0;0;0;0;5",
            "testProject;testFile2;file2;40;14;5;1;1;1;1;1;0;1;1;1;1;1;1;1;1;1;1;1;1;1;0"
    };
    @Test
    void testGetSmells() {
        HashMap<String,Integer> result = main.getSmells(exampleTestSmellResult);
        HashMap<String,Integer> expectedOutput = new HashMap<>();

        expectedOutput.put("LOC", 90);
        assertEquals(90,result.get("LOC"));

        expectedOutput.put("numberMethods", 30);
        assertEquals(30,result.get("numberMethods"));

        expectedOutput.put("Assertion Roulette",13);
        assertEquals(13,result.get("Assertion Roulette"));

        expectedOutput.put("Eager Test", 1);
        assertEquals(1,result.get("Eager Test"));

        expectedOutput.put("Mystery Guest", 1);
        assertEquals(1,result.get("Mystery Guest"));

        expectedOutput.put("Sleepy Test", 1);
        assertEquals(1,result.get("Sleepy Test"));

        expectedOutput.put("Unknown Test", 1);
        assertEquals(1,result.get("Unknown Test"));

        expectedOutput.put("Redundant Assertion", 1);
        assertEquals(1,result.get("Redundant Assertion"));

        expectedOutput.put("Dependent Test", 8);
        assertEquals(8,result.get("Dependent Test"));

        expectedOutput.put("Magic Number Test", 1);
        assertEquals(1,result.get("Magic Number Test"));

        expectedOutput.put("Resource Optimism", 1);
        assertEquals(1,result.get("Resource Optimism"));

        expectedOutput.put("Conditional Test Logic", 1);
        assertEquals(1,result.get("Conditional Test Logic"));

        expectedOutput.put("EmptyTest", 1);
        assertEquals(1,result.get("EmptyTest"));

        expectedOutput.put("General Fixture", 1);
        assertEquals(1,result.get("General Fixture"));

        expectedOutput.put("IgnoredTest", 1);
        assertEquals(1,result.get("IgnoredTest"));

        expectedOutput.put("Sensitive Equality", 1);
        assertEquals(1,result.get("Sensitive Equality"));

        expectedOutput.put("Verbose Test", 1);
        assertEquals(1,result.get("Verbose Test"));

        expectedOutput.put("Default Test", 1);
        assertEquals(1,result.get("Default Test"));

        expectedOutput.put("Duplicate Assert", 1);
        assertEquals(1,result.get("Duplicate Assert"));

        expectedOutput.put("Exception Catching Throwing", 1);
        assertEquals(1,result.get("Exception Catching Throwing"));

        expectedOutput.put("Constructor Initialization", 1);
        assertEquals(1,result.get("Constructor Initialization"));

        expectedOutput.put("Print Statement", 1);
        assertEquals(1,result.get("Print Statement"));

        expectedOutput.put("Lazy Test", 5);
        assertEquals(5,result.get("Lazy Test"));

        //Check that total result is equal
        assertEquals(expectedOutput, result);
    }
}