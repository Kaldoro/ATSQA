import Enums.TestSmell;
import Enums.HarmType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TSHarm {
    //Values which combined and averaged out make up the Stability modifier
    static List<Double> assertionRouletteStabModifiers = new ArrayList<>();
    static List<Double> sensitiveEqualityStabModifiers = new ArrayList<>();
    static List<Double> eagerTestStabModifiers = new ArrayList<>();
    static List<Double> resourceOptimismStabModifiers = new ArrayList<>();
    static List<Double> mysteryGuestStabModifiers = new ArrayList<>();
    static List<Double> generalFixtureStabModifiers = new ArrayList<>();
    static List<Double> lazyTestStabModifiers = new ArrayList<>();

    //Values which combined and averaged out make up the Effectiveness modifier
    static List<Double> assertionRouletteEffModifiers = new ArrayList<>();
    static List<Double> sensitiveEqualityEffModifiers = new ArrayList<>();
    static List<Double> eagerTestEffModifiers = new ArrayList<>();
    static List<Double> resourceOptimismEffModifiers = new ArrayList<>();
    static List<Double> mysteryGuestEffModifiers = new ArrayList<>();


    //Effectiveness modifiers
    static double assertionRouletteEffMod;
    static double sensitiveEqualityEffMod;
    static double eagerTestEffMod;
    static double resourceOptimismEffMod;
    static double mysteryGuestEffMod;
    static double generalFixtureEffMod;
    static double lazyTestEffMod;

    //Stability modifiers
    static double assertionRouletteStabMod;
    static double sensitiveEqualityStabMod;
    static double eagerTestStabMod;
    static double resourceOptimismStabMod;
    static double mysteryGuestStabMod;
    static double generalFixtureStabMod;
    static double lazyTestStabMod;

    //Title: To What Extent Can Code Quality be Improved by Eliminating Test Smells?
    //Authors: Haitao Wu,Ruidi Yin,Jianhua Gao,Zijie Huang,Huajun Huang
    //Year: 2022
    public static void Wu2022() {
        //Stability modifiers
        assertionRouletteStabModifiers.add(0.6436);
        sensitiveEqualityStabModifiers.add(0.8293);
        eagerTestStabModifiers.add(0.7578);
        resourceOptimismStabModifiers.add(0.6783);
        mysteryGuestStabModifiers.add(0.7623);

        //Effectiveness modifiers
        assertionRouletteEffModifiers.add(0.8374);
        sensitiveEqualityEffModifiers.add(0.8810);
        eagerTestEffModifiers.add(0.8606);
        resourceOptimismEffModifiers.add(0.8304);
        mysteryGuestEffModifiers.add(0.8810);
    }

    //Title: Are test smells really harmful? An empirical study
    //Authors: Gabriele Bavota, Abdallah Qusef, Rocco Oliveto, Andrea De Lucia, Dave Binkley
    //Year: 2015
    public static void Bavota2015() {
        //Stability modifiers
        assertionRouletteStabModifiers.add(0.55);
        sensitiveEqualityStabModifiers.add(0.24);
        eagerTestStabModifiers.add(0.34);
        resourceOptimismStabModifiers.add(0.49);
        mysteryGuestStabModifiers.add(0.49);
        generalFixtureStabModifiers.add(0.17);
        lazyTestStabModifiers.add(0.20);
    }

    public static void calcModifiers() {
        //Add results from studies
        Bavota2015();
        Wu2022();

        //Calculate effectiveness modifiers
        assertionRouletteEffMod = calcAverage(assertionRouletteEffModifiers);
        sensitiveEqualityEffMod = calcAverage(sensitiveEqualityEffModifiers);
        eagerTestEffMod = calcAverage(eagerTestEffModifiers);
        resourceOptimismEffMod = calcAverage(resourceOptimismEffModifiers);
        mysteryGuestEffMod = calcAverage(mysteryGuestEffModifiers);

        //Calculate stability modifiers
        assertionRouletteStabMod = calcAverage(assertionRouletteStabModifiers);
        sensitiveEqualityStabMod = calcAverage(sensitiveEqualityStabModifiers);
        eagerTestStabMod = calcAverage(eagerTestStabModifiers);
        resourceOptimismStabMod = calcAverage(resourceOptimismStabModifiers);
        mysteryGuestStabMod = calcAverage(mysteryGuestStabModifiers);
        generalFixtureStabMod = calcAverage(generalFixtureStabModifiers);
        lazyTestStabMod = calcAverage(lazyTestStabModifiers);
    }


    //Adds all the numbers together and extracts the average
    public static Double calcAverage(List<Double> values) {
        Double total = 0.0;
        for(Double elem : values) {
            total += elem;
        }
        return total / values.size();
    }

    public static double getSmellHarm(HarmType harmType, TestSmell name, HashMap<String,Integer> smells) {
        //Get the harm modifier
        double modifier = getModifier(harmType,name);

        //Get how often the particular test smell occurs in the project.
        Integer smellCount = smells.get(name.getNameStr());

        //Determine the smell density per 500 lines of test code
        double smellDensity = smellCount / (smells.get("LOC") / 500.0);

        return smellDensity * modifier;
    }

     static Double getModifier(HarmType harmType, TestSmell name) {
        double modifier = 0;
        if(harmType == HarmType.Effectiveness) {
            switch (name) {
                case Assertion_Roulette:
                    modifier = assertionRouletteEffMod;
                    break;
                case Sensitive_Equality:
                    modifier = sensitiveEqualityEffMod;
                    break;
                case Eager_Test:
                    modifier = eagerTestEffMod;
                    break;
                case Resource_Optimism:
                    modifier = resourceOptimismEffMod;
                    break;
                case Mystery_Guest:
                    modifier = mysteryGuestEffMod;
                    break;
                case General_Fixture:
                    modifier = generalFixtureEffMod;
                    break;
                case Lazy_Test:
                    modifier = lazyTestEffMod;
                    break;
                default:
                    throw new Error("Invalid test smell name");
            }
        }
        else if (harmType == HarmType.Stability) {
            switch (name) {
                case Assertion_Roulette:
                    modifier = assertionRouletteStabMod;
                    break;
                case Sensitive_Equality:
                    modifier = sensitiveEqualityStabMod;
                    break;
                case Eager_Test:
                    modifier = eagerTestStabMod;
                    break;
                case Resource_Optimism:
                    modifier = resourceOptimismStabMod;
                    break;
                case Mystery_Guest:
                    modifier = mysteryGuestStabMod;
                    break;
                case General_Fixture:
                    modifier = generalFixtureStabMod;
                    break;
                case Lazy_Test:
                    modifier = lazyTestStabMod;
                    break;
                default:
                    throw new Error("Invalid test smell name");
            }
        }

        return modifier;
    }
}
