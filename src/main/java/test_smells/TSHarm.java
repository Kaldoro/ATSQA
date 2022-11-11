package test_smells;

import enums.TestSmell;
import enums.HarmType;
import util.Pair;
import java.util.EnumMap;
import java.util.Map;

public class TSHarm {
    TSHarm() {

    }
    public static Map<TestSmell,Double> effectivenessModifiers = new EnumMap<>(TestSmell.class);
    public static Map<TestSmell,Double> maintainabilityModifiers = new EnumMap<>(TestSmell.class);

    public static void init() {
        Pair<EnumMap<TestSmell, Double>, EnumMap<TestSmell, Double>> results = TSStudies.calcModifiers();
        effectivenessModifiers = results.a;
        maintainabilityModifiers = results.b;
    }

    public static double getSmellHarm(HarmType harmType, TestSmell name, Map<String,Integer> smells) {
        //Get the harm modifier
        double modifier = getModifier(harmType,name);

        //Get how often the particular test smell occurs in the project.
        Integer smellCount = smells.get(name.getNameStr());

        if(smellCount == null) {
            return 0;
        }
        //Determine the smell density per 500 lines of test code
        double smellDensity = smellCount / (smells.get("LOC") / 500.0);

        return smellDensity * modifier;
    }

     static Double getModifier(HarmType harmType, TestSmell name) {
        double modifier = 0;
        if(harmType == HarmType.EFFECTIVENESS) {
           modifier = effectivenessModifiers.get(name);
        }
        else if (harmType == HarmType.MAINTAINABILITY) {
           modifier = maintainabilityModifiers.get(name);
        }
        return modifier;
    }
}