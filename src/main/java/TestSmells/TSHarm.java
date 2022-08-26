package TestSmells;

import Enums.TestSmell;
import Enums.HarmType;
import util.Pair;

import java.util.HashMap;

public class TSHarm {
    static HashMap<TestSmell,Double> effectivenessModifiers = new HashMap<>();
    static HashMap<TestSmell,Double> stabilityModifiers = new HashMap<>();

    public static void Init() {
        Pair<HashMap<TestSmell, Double>, HashMap<TestSmell, Double>> results = TSStudies.calcModifiers();
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
        if(harmType == HarmType.Effectiveness) {
           modifier = effectivenessModifiers.get(name);
        }
        else if (harmType == HarmType.Stability) {
           modifier = stabilityModifiers.get(name);
        }
        return modifier;
    }
}