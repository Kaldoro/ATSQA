package TestSmells;

import Enums.TestSmell;
import util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class TSStudies {
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

    static HashMap<TestSmell,Double> effectivenessModifiers = new HashMap<>();
    static HashMap<TestSmell,Double> stabilityModifiers = new HashMap<>();

    //Title: To What Extent Can Code Quality be Improved by Eliminating Test Smells?
    //Authors: Haitao Wu,Ruidi Yin,Jianhua Gao,Zijie Huang,Huajun Huang
    //Year: 2022
    static void Wu2022() {
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
    static void Bavota2015() {
        //Stability modifiers
        assertionRouletteStabModifiers.add(0.55);
        sensitiveEqualityStabModifiers.add(0.24);
        eagerTestStabModifiers.add(0.34);
        resourceOptimismStabModifiers.add(0.49);
        mysteryGuestStabModifiers.add(0.49);
        generalFixtureStabModifiers.add(0.17);
        lazyTestStabModifiers.add(0.20);
    }

    public static Pair<HashMap<TestSmell, Double>, HashMap<TestSmell, Double>> calcModifiers() {
        //Add results from studies
        Bavota2015();
        Wu2022();

        calcEffectivenessModifiers();
        calcStabilityModifiers();

        return new Pair<HashMap<TestSmell, Double>, HashMap<TestSmell, Double>>(effectivenessModifiers,stabilityModifiers);
    }

    static void calcEffectivenessModifiers() {
        //Calculate effectiveness modifiers
        effectivenessModifiers.put(TestSmell.Assertion_Roulette,calcAverage(assertionRouletteEffModifiers));
        effectivenessModifiers.put(TestSmell.Sensitive_Equality,calcAverage(sensitiveEqualityEffModifiers));
        effectivenessModifiers.put(TestSmell.Eager_Test,calcAverage(eagerTestEffModifiers));
        effectivenessModifiers.put(TestSmell.Resource_Optimism,calcAverage(resourceOptimismEffModifiers));
        effectivenessModifiers.put(TestSmell.Mystery_Guest,calcAverage(mysteryGuestEffModifiers));
        effectivenessModifiers.put(TestSmell.General_Fixture,0.0);
        effectivenessModifiers.put(TestSmell.Lazy_Test,0.0);
    }

    static void calcStabilityModifiers() {
        //Calculate stability modifiers
        stabilityModifiers.put(TestSmell.Assertion_Roulette,calcAverage(assertionRouletteStabModifiers));
        stabilityModifiers.put(TestSmell.Sensitive_Equality,calcAverage(sensitiveEqualityStabModifiers));
        stabilityModifiers.put(TestSmell.Eager_Test,calcAverage(eagerTestStabModifiers));
        stabilityModifiers.put(TestSmell.Resource_Optimism,calcAverage(resourceOptimismStabModifiers));
        stabilityModifiers.put(TestSmell.Mystery_Guest,calcAverage(mysteryGuestStabModifiers));
        stabilityModifiers.put(TestSmell.General_Fixture,calcAverage(generalFixtureStabModifiers));
        stabilityModifiers.put(TestSmell.Lazy_Test,calcAverage(lazyTestStabModifiers));

    }

    //Adds all the numbers together and extracts the average
    static Double calcAverage(List<Double> values) {
        Double total = 0.0;
        for(Double elem : values) {
            total += elem;
        }
        return total / values.size();
    }
}