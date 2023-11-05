package test_smells;

import enums.TestSmell;
import util.Pair;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class TSStudies {
    TSStudies() {

    }
    //Values which combined and averaged out make up the Maintainability modifier
    static List<Double> assertionRouletteMainModifiers = new ArrayList<>();
    static List<Double> sensitiveEqualityMainModifiers = new ArrayList<>();
    static List<Double> eagerTestMainModifiers = new ArrayList<>();
    static List<Double> resourceOptimismMainModifiers = new ArrayList<>();
    static List<Double> mysteryGuestMainModifiers = new ArrayList<>();
    static List<Double> generalFixtureMainModifiers = new ArrayList<>();
    static List<Double> lazyTestMainModifiers = new ArrayList<>();
    static List<Double> indirectTestingMainModifiers = new ArrayList<>();
    static List<Double> codeDuplicationMainModifiers = new ArrayList<>();

    //Values which combined and averaged out make up the Effectiveness modifier
    static List<Double> assertionRouletteEffModifiers = new ArrayList<>();
    static List<Double> sensitiveEqualityEffModifiers = new ArrayList<>();
    static List<Double> eagerTestEffModifiers = new ArrayList<>();
    static List<Double> resourceOptimismEffModifiers = new ArrayList<>();
    static List<Double> mysteryGuestEffModifiers = new ArrayList<>();
    static List<Double> indirectTestingEffModifiers = new ArrayList<>();

    static EnumMap<TestSmell,Double> effectivenessModifiers = new EnumMap<>(TestSmell.class);
    static EnumMap<TestSmell,Double> maintainabilityModifiers = new EnumMap<>(TestSmell.class);

    //Title: To What Extent Can Code Quality be Improved by Eliminating Test Smells?
    //Authors: Haitao Wu,Ruidi Yin,Jianhua Gao,Zijie Huang,Huajun Huang
    //Year: 2022
    static void wu2022() {
        //Maintainability modifiers
        assertionRouletteMainModifiers.add(0.6436);
        sensitiveEqualityMainModifiers.add(0.8293);
        eagerTestMainModifiers.add(0.7578);
        resourceOptimismMainModifiers.add(0.6783);
        mysteryGuestMainModifiers.add(0.7623);

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
        //Maintainability modifiers
        assertionRouletteMainModifiers.add(0.55);
        sensitiveEqualityMainModifiers.add(0.24);
        eagerTestMainModifiers.add(0.34);
        resourceOptimismMainModifiers.add(0.49);
        mysteryGuestMainModifiers.add(0.49);
        generalFixtureMainModifiers.add(0.17);
        lazyTestMainModifiers.add(0.20);
        indirectTestingMainModifiers.add(0.21);
        codeDuplicationMainModifiers.add(0.25);

    }

    //Title: On The Relation of Test Smells to Software Code Quality
    //Authors: Davide Spadini, Fabio Palomba,  Andy Zaidman, Magiel Bruntink,Alberto Bacchelli
    //Year: 2018
    static void spadini2018() {
        //Maintainability modifiers
        assertionRouletteMainModifiers.add(0.054958);
        eagerTestMainModifiers.add(0.613752);
        mysteryGuestMainModifiers.add(0.19943);
        indirectTestingMainModifiers.add(0.405589);

        //Effectiveness modifiers
        assertionRouletteEffModifiers.add(0.846974);
        eagerTestEffModifiers.add(1.232508);
        mysteryGuestEffModifiers.add(0.931232);
        indirectTestingEffModifiers.add(1.270874);
    }

    public static Pair<EnumMap<TestSmell, Double>, EnumMap<TestSmell, Double>> calcModifiers() {
        //Add results from studies
        bavota2015();
        wu2022();
        spadini2018();

        calcEffectivenessModifiers();
        calcMaintainabilityModifiers();

        return new Pair<>(effectivenessModifiers,maintainabilityModifiers);
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
        effectivenessModifiers.put(TestSmell.INDIRECT_TESTING,calcAverage(indirectTestingEffModifiers));
        effectivenessModifiers.put(TestSmell.TEST_CODE_DUPLICATION,0.0);
    }

    static void calcMaintainabilityModifiers() {
        //Calculate maintainability modifiers
        maintainabilityModifiers.put(TestSmell.ASSERTION_ROULETTE,calcAverage(assertionRouletteMainModifiers));
        maintainabilityModifiers.put(TestSmell.SENSITIVE_EQUALITY,calcAverage(sensitiveEqualityMainModifiers));
        maintainabilityModifiers.put(TestSmell.EAGER_TEST,calcAverage(eagerTestMainModifiers));
        maintainabilityModifiers.put(TestSmell.RESOURCE_OPTIMISM,calcAverage(resourceOptimismMainModifiers));
        maintainabilityModifiers.put(TestSmell.MYSTERY_GUEST,calcAverage(mysteryGuestMainModifiers));
        maintainabilityModifiers.put(TestSmell.GENERAL_FIXTURE,calcAverage(generalFixtureMainModifiers));
        maintainabilityModifiers.put(TestSmell.LAZY_TEST,calcAverage(lazyTestMainModifiers));
        maintainabilityModifiers.put(TestSmell.INDIRECT_TESTING,calcAverage(indirectTestingMainModifiers));
        maintainabilityModifiers.put(TestSmell.TEST_CODE_DUPLICATION,calcAverage(codeDuplicationMainModifiers));
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