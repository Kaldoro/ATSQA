package testSmells;

import enums.TestSmell;
import util.Pair;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class TSStudies {
    TSStudies() {

    }
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

    static EnumMap<TestSmell,Double> effectivenessModifiers = new EnumMap<>(TestSmell.class);
    static EnumMap<TestSmell,Double> stabilityModifiers = new EnumMap<>(TestSmell.class);

    //Title: To What Extent Can Code Quality be Improved by Eliminating Test Smells?
    //Authors: Haitao Wu,Ruidi Yin,Jianhua Gao,Zijie Huang,Huajun Huang
    //Year: 2022
    static void wu2022() {
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
    static void bavota2015() {
        //Stability modifiers
        assertionRouletteStabModifiers.add(0.55);
        sensitiveEqualityStabModifiers.add(0.24);
        eagerTestStabModifiers.add(0.34);
        resourceOptimismStabModifiers.add(0.49);
        mysteryGuestStabModifiers.add(0.49);
        generalFixtureStabModifiers.add(0.17);
        lazyTestStabModifiers.add(0.20);
    }

    public static Pair<EnumMap<TestSmell, Double>, EnumMap<TestSmell, Double>> calcModifiers() {
        //Add results from studies
        bavota2015();
        wu2022();

        calcEffectivenessModifiers();
        calcStabilityModifiers();

        return new Pair<EnumMap<TestSmell, Double>, EnumMap<TestSmell, Double>>(effectivenessModifiers,stabilityModifiers);
    }

    static void calcEffectivenessModifiers() {
        //Calculate effectiveness modifiers
        effectivenessModifiers.put(TestSmell.ASSERTION_ROULETTE,calcAverage(assertionRouletteEffModifiers));
        effectivenessModifiers.put(TestSmell.SENSITIVE_EQUALITY,calcAverage(sensitiveEqualityEffModifiers));
        effectivenessModifiers.put(TestSmell.EAGER_TEST,calcAverage(eagerTestEffModifiers));
        effectivenessModifiers.put(TestSmell.RESOURCE_OPTIMISM,calcAverage(resourceOptimismEffModifiers));
        effectivenessModifiers.put(TestSmell.MYSTERY_GUEST,calcAverage(mysteryGuestEffModifiers));
        effectivenessModifiers.put(TestSmell.GENERAL_FIXTURE,0.0);
        effectivenessModifiers.put(TestSmell.LAZY_TEST,0.0);
    }

    static void calcStabilityModifiers() {
        //Calculate stability modifiers
        stabilityModifiers.put(TestSmell.ASSERTION_ROULETTE,calcAverage(assertionRouletteStabModifiers));
        stabilityModifiers.put(TestSmell.SENSITIVE_EQUALITY,calcAverage(sensitiveEqualityStabModifiers));
        stabilityModifiers.put(TestSmell.EAGER_TEST,calcAverage(eagerTestStabModifiers));
        stabilityModifiers.put(TestSmell.RESOURCE_OPTIMISM,calcAverage(resourceOptimismStabModifiers));
        stabilityModifiers.put(TestSmell.MYSTERY_GUEST,calcAverage(mysteryGuestStabModifiers));
        stabilityModifiers.put(TestSmell.GENERAL_FIXTURE,calcAverage(generalFixtureStabModifiers));
        stabilityModifiers.put(TestSmell.LAZY_TEST,calcAverage(lazyTestStabModifiers));

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