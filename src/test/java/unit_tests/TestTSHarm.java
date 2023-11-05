package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import enums.HarmType;
import enums.TestSmell;
import org.junit.jupiter.api.Test;
import test_smells.TSHarm;
import java.util.HashMap;

class TestTSHarm {
     HashMap<String,Integer> exampleSmells = new HashMap() {{
        put("LOC", 90);
        put("numberMethods", 15);
        put("Assertion Roulette",5);
        put("Eager Test",2);
        put("Mystery Guest", 3);
        put("Sleepy Test", 3);
        put("Unknown Test", 3);
        put("Redundant Assertion", 3);
        put("Dependent Test", 3);
        put("Magic Number Test", 3);
        put("Conditional Test Logic", 3);
        put("EmptyTest", 3);
        put("General Fixture", 3);
        put("IgnoredTest", 3);
        put("Sensitive Equality", 3);
        put("Verbose Test", 3);
        put("Default Test", 3);
        put("Resource Optimism", 3);
        put("Duplicate Assert", 3);
        put("Exception Catching Throwing", 3);
        put("Constructor Initialization", 3);
        put("Print Statement", 3);
        put("Lazy Test", 3);
    }};

    @Test
    void testGetSmellHarmEffectiveness() {
        //Mock the harm modifiers
        double assertionRouletteHarmModifier = 0.5;
        TSHarm.effectivenessModifiers.put(TestSmell.ASSERTION_ROULETTE, assertionRouletteHarmModifier);

        double actualResult = TSHarm.getSmellHarm(HarmType.EFFECTIVENESS, TestSmell.ASSERTION_ROULETTE, exampleSmells);
        double expectedDensity = exampleSmells.get("Assertion Roulette") / (exampleSmells.get("LOC") / 500.0) ;
        double expectedResult = expectedDensity * assertionRouletteHarmModifier;

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void testGetSmellHarmMaintainability() {
        //Mock the harm modifiers
        double eagerRouletteHarmModifier = 0.3;
        TSHarm.maintainabilityModifiers.put(TestSmell.EAGER_TEST, eagerRouletteHarmModifier);

        double actualResult = TSHarm.getSmellHarm(HarmType.MAINTAINABILITY, TestSmell.EAGER_TEST, exampleSmells);
        double expectedDensity = exampleSmells.get("Eager Test") / (exampleSmells.get("LOC") / 500.0) ;
        double expectedResult = expectedDensity * eagerRouletteHarmModifier;

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void testInit() {
        TSHarm.init();
        double mainAssertionModifier = TSHarm.maintainabilityModifiers.get(TestSmell.ASSERTION_ROULETTE);
        assertNotEquals(0, mainAssertionModifier);
    }
}
