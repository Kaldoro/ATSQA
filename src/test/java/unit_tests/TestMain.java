package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ATSQA_main.main;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

class TestMain {

    static class TestFile {
        public String fileName;
        public String productionFileName;
        public int LOC;
        public int numberMethods;
        public int assertionRoulette;
        public int eagerTest;
        public int mysteryGuest;
        public int sleepyTest;
        public int unknownTest;
        public int redundantAssertion;
        public int dependentTest;
        public int magicNumberTest;
        public int conditionalTestLogic;
        public int emptyTest;
        public int generalFixture;
        public int ignoredTest;
        public int sensitiveEquality;
        public int verboseTest;
        public int defaultTest;
        public int resourceOptimism;
        public int duplicateAssert;
        public int exceptionCatchingThrowing;
        public int constructorInitialization;
        public int printStatement;
        public int lazyTest;
        public TestFile(String file_name, String production_file_name, int TLOC, int number_methods, int assertion_roulette, int eager_test, int mystery_guest, int sleepy_test,
                        int unknown_test, int redundant_assertion, int dependent_test, int magic_number_test, int conditional_test_logic, int empty_test, int general_fixture,
                        int ignored_test, int sensitive_equality, int verbose_test, int default_test, int resource_optimism, int duplicate_assert, int exception_catching_throwing,
                        int constructor_initialization, int print_statement, int lazy_test) {
            fileName = file_name;
            productionFileName = production_file_name;
            LOC = TLOC;
            numberMethods = number_methods;
            assertionRoulette = assertion_roulette;
            eagerTest = eager_test;
            mysteryGuest = mystery_guest;
            sleepyTest = sleepy_test;
            unknownTest = unknown_test;
            redundantAssertion = redundant_assertion;
            dependentTest = dependent_test;
            magicNumberTest = magic_number_test;
            conditionalTestLogic = conditional_test_logic;
            emptyTest = empty_test;
            generalFixture = general_fixture;
            ignoredTest = ignored_test;
            sensitiveEquality = sensitive_equality;
            verboseTest = verbose_test;
            defaultTest = default_test;
            resourceOptimism = resource_optimism;
            duplicateAssert = duplicate_assert;
            exceptionCatchingThrowing = exception_catching_throwing;
            constructorInitialization = constructor_initialization;
            printStatement = print_statement;
            lazyTest = lazy_test;
        }
        public String printFileInfo () {
            String testProject = "testProject";
            return testProject + ";" + fileName + ";" + productionFileName + ";" + LOC + ";" + numberMethods + ";" + assertionRoulette + ";" + eagerTest + ";" + mysteryGuest + ";" + sleepyTest + ";" + unknownTest + ";" + redundantAssertion + ";" + dependentTest + ";" + magicNumberTest + ";" + conditionalTestLogic + ";" + emptyTest + ";" + generalFixture + ";" + ignoredTest + ";" + sensitiveEquality + ";" + verboseTest + ";" + defaultTest + ";" + resourceOptimism + ";" + duplicateAssert + ";" + exceptionCatchingThrowing + ";" + constructorInitialization + ";" + printStatement + ";" + lazyTest ;
        }

    }
    TestFile testFile1 = new TestFile("testFile1", "file1", 50, 8, 8, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
    TestFile testFile2 = new TestFile("testFile2", "file2", 40, 7, 5, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0);

    @Test
    void testGetSmells() {
        String[] exampleTestSmellResult = new String[] {
                "App;TestFileName;ProductionFileName;LOC;numberMethods;Assertion Roulette;Eager Test;Mystery Guest;Sleepy Test;Unknown Test;Redundant Assertion;Dependent Test;Magic Number Test;Conditional Test Logic;EmptyTest;General Fixture;IgnoredTest;Sensitive Equality;Verbose Test;Default Test;Resource Optimism;Duplicate Assert;Exception Catching Throwing;Constructor Initialization;Print Statement;Lazy Test",
                testFile1.printFileInfo(),
                testFile2.printFileInfo()
        };
        HashMap<String,Integer> result = main.getSmells(exampleTestSmellResult);
        HashMap<String,Integer> expectedOutput = new HashMap<>();

        int expectedLOC = testFile1.LOC + testFile2.LOC;
        expectedOutput.put("LOC", expectedLOC);
        assertEquals(expectedLOC,result.get("LOC"));

        int expectedNumberMethods = testFile1.numberMethods + testFile2.numberMethods;
        expectedOutput.put("numberMethods", expectedNumberMethods);
        assertEquals(expectedNumberMethods,result.get("numberMethods"));

        int expectedAssertionRoulette = testFile1.assertionRoulette + testFile2.assertionRoulette;
        expectedOutput.put("Assertion Roulette",expectedAssertionRoulette);
        assertEquals(expectedAssertionRoulette,result.get("Assertion Roulette"));

        int expectedEagerTest = testFile1.eagerTest + testFile2.eagerTest;
        expectedOutput.put("Eager Test", expectedEagerTest);
        assertEquals(expectedEagerTest,result.get("Eager Test"));

        int expectedMysteryGuest = testFile1.mysteryGuest + testFile2.mysteryGuest;
        expectedOutput.put("Mystery Guest", expectedMysteryGuest);
        assertEquals(expectedMysteryGuest,result.get("Mystery Guest"));

        int expectedSleepyTest = testFile1.sleepyTest + testFile2.sleepyTest;
        expectedOutput.put("Sleepy Test", expectedSleepyTest);
        assertEquals(expectedSleepyTest,result.get("Sleepy Test"));

        int expectedUnknownTest = testFile1.unknownTest + testFile2.unknownTest;
        expectedOutput.put("Unknown Test", expectedUnknownTest);
        assertEquals(expectedUnknownTest,result.get("Unknown Test"));

        int expectedRedundantAssertion = testFile1.redundantAssertion + testFile2.redundantAssertion;
        expectedOutput.put("Redundant Assertion", expectedRedundantAssertion);
        assertEquals(expectedRedundantAssertion,result.get("Redundant Assertion"));

        int expectedDependentTest = testFile1.dependentTest + testFile2.dependentTest;
        expectedOutput.put("Dependent Test", expectedDependentTest);
        assertEquals(expectedDependentTest,result.get("Dependent Test"));

        int expectedMagicNumberTest = testFile1.magicNumberTest + testFile2.magicNumberTest;
        expectedOutput.put("Magic Number Test", expectedMagicNumberTest);
        assertEquals(expectedMagicNumberTest,result.get("Magic Number Test"));

        int expectedResourceOptimism = testFile1.resourceOptimism + testFile2.resourceOptimism;
        expectedOutput.put("Resource Optimism", expectedResourceOptimism);
        assertEquals(expectedResourceOptimism,result.get("Resource Optimism"));

        int expectedConditionalTestLogic = testFile1.conditionalTestLogic + testFile2.conditionalTestLogic;
        expectedOutput.put("Conditional Test Logic", expectedConditionalTestLogic);
        assertEquals(expectedConditionalTestLogic,result.get("Conditional Test Logic"));

        int expectedEmptyTest = testFile1.emptyTest + testFile2.emptyTest;
        expectedOutput.put("EmptyTest", expectedEmptyTest);
        assertEquals(expectedEmptyTest,result.get("EmptyTest"));

        int expectedGeneralFixture = testFile1.generalFixture + testFile2.generalFixture;
        expectedOutput.put("General Fixture", expectedGeneralFixture);
        assertEquals(expectedGeneralFixture,result.get("General Fixture"));

        int expectedIgnoredTest = testFile1.ignoredTest + testFile2.ignoredTest;
        expectedOutput.put("IgnoredTest", expectedIgnoredTest);
        assertEquals(expectedIgnoredTest,result.get("IgnoredTest"));

        int expectedSensitiveEquality = testFile1.sensitiveEquality + testFile2.sensitiveEquality;
        expectedOutput.put("Sensitive Equality", expectedSensitiveEquality);
        assertEquals(expectedSensitiveEquality,result.get("Sensitive Equality"));

        int expectedVerboseTest = testFile1.verboseTest + testFile2.verboseTest;
        expectedOutput.put("Verbose Test", expectedVerboseTest);
        assertEquals(expectedVerboseTest,result.get("Verbose Test"));

        int expectedDefaultTest = testFile1.defaultTest + testFile2.defaultTest;
        expectedOutput.put("Default Test", expectedDefaultTest);
        assertEquals(expectedDefaultTest,result.get("Default Test"));

        int expectedDuplicateAssert = testFile1.duplicateAssert + testFile2.duplicateAssert;
        expectedOutput.put("Duplicate Assert", expectedDuplicateAssert);
        assertEquals(expectedDuplicateAssert,result.get("Duplicate Assert"));

        int expectedExceptionCatchingThrowing = testFile1.exceptionCatchingThrowing + testFile2.exceptionCatchingThrowing;
        expectedOutput.put("Exception Catching Throwing", expectedExceptionCatchingThrowing);
        assertEquals(expectedExceptionCatchingThrowing,result.get("Exception Catching Throwing"));

        int expectedConstructorInitialization = testFile1.constructorInitialization + testFile2.constructorInitialization;
        expectedOutput.put("Constructor Initialization", expectedConstructorInitialization);
        assertEquals(expectedConstructorInitialization,result.get("Constructor Initialization"));

        int expectedPrintStatement = testFile1.printStatement + testFile2.printStatement;
        expectedOutput.put("Print Statement", expectedPrintStatement);
        assertEquals(expectedPrintStatement,result.get("Print Statement"));

        int expectedLazyTest = testFile1.lazyTest + testFile2.lazyTest;
        expectedOutput.put("Lazy Test", expectedLazyTest);
        assertEquals(expectedLazyTest,result.get("Lazy Test"));

        //Check that total result is equal
        assertEquals(expectedOutput, result);
    }
}