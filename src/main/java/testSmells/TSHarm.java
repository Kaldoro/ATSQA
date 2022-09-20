package testSmells;

import enums.TestSmell;
import enums.HarmType;
import util.Pair;

import java.util.EnumMap;
import java.util.HashMap;

public class TSHarm {
    TSHarm() {

    }
    static EnumMap<TestSmell,Double> effectivenessModifiers = new EnumMap<>(TestSmell.class);
    static EnumMap<TestSmell,Double> stabilityModifiers = new EnumMap<>(TestSmell.class);

    public static void init() {
        Pair<EnumMap<TestSmell, Double>, EnumMap<TestSmell, Double>> results = TSStudies.calcModifiers();
        effectivenessModifiers = results.a;
        stabilityModifiers = results.b;
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
        if(harmType == HarmType.EFFECTIVENESS) {
           modifier = effectivenessModifiers.get(name);
        }
        else if (harmType == HarmType.STABILITY) {
           modifier = stabilityModifiers.get(name);
        }
        return modifier;
    }
}