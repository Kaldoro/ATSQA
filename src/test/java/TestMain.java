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
        HashMap<String,Integer> expectedOutput = new HashMap<String,Integer>();

        expectedOutput.put("LOC", 90);
        assertEquals(result.get("LOC"),90);

        expectedOutput.put("numberMethods", 30);
        assertEquals(result.get("numberMethods"),30);

        expectedOutput.put("Assertion Roulette",13);
        assertEquals(result.get("Assertion Roulette"),13);

        expectedOutput.put("Eager Test", 1);
        assertEquals(result.get("Eager Test"),1);

        expectedOutput.put("Mystery Guest", 1);
        assertEquals(result.get("Mystery Guest"),1);

        expectedOutput.put("Sleepy Test", 1);
        assertEquals(result.get("Sleepy Test"),1);

        expectedOutput.put("Unknown Test", 1);
        assertEquals(result.get("Unknown Test"),1);

        expectedOutput.put("Redundant Assertion", 1);
        assertEquals(result.get("Redundant Assertion"),1);

        expectedOutput.put("Dependent Test", 8);
        assertEquals(result.get("Dependent Test"),8);

        expectedOutput.put("Magic Number Test", 1);
        assertEquals(result.get("Magic Number Test"),1);

        expectedOutput.put("Resource Optimism", 1);
        assertEquals(result.get("Resource Optimism"),1);

        expectedOutput.put("Conditional Test Logic", 1);
        assertEquals(result.get("Conditional Test Logic"),1);

        expectedOutput.put("EmptyTest", 1);
        assertEquals(result.get("EmptyTest"),1);

        expectedOutput.put("General Fixture", 1);
        assertEquals(result.get("General Fixture"),1);

        expectedOutput.put("IgnoredTest", 1);
        assertEquals(result.get("IgnoredTest"),1);

        expectedOutput.put("Sensitive Equality", 1);
        assertEquals(result.get("Sensitive Equality"),1);

        expectedOutput.put("Verbose Test", 1);
        assertEquals(result.get("Verbose Test"),1);

        expectedOutput.put("Default Test", 1);
        assertEquals(result.get("Default Test"),1);

        expectedOutput.put("Duplicate Assert", 1);
        assertEquals(result.get("Duplicate Assert"),1);

        expectedOutput.put("Exception Catching Throwing", 1);
        assertEquals(result.get("Exception Catching Throwing"),1);

        expectedOutput.put("Constructor Initialization", 1);
        assertEquals(result.get("Constructor Initialization"),1);

        expectedOutput.put("Print Statement", 1);
        assertEquals(result.get("Print Statement"),1);

        expectedOutput.put("Lazy Test", 5);
        assertEquals(result.get("Lazy Test"),5);

        //Check that total result is equal
        assertEquals(expectedOutput, result);
    }
}

