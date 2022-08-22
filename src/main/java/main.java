import Enums.TestSmell;
import Enums.HarmType;
import File.FileFuncs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args) {
        /**IMPORTANT**///Calculates the correct modifiers for the test smells
        TSHarm.calcModifiers();

        String[] mutationResult = FileFuncs.readFile("index.html");
        String[] testSmellResult = FileFuncs.readFile("Password-Gen_TS_General.csv");

        if(mutationResult.length > 0) {
            //Extract the lineCoverage percentage and the percentage of mutants killed
            String lineCoverageStr = mutationResult[21].replaceAll("\\s+","").substring(4).split("%")[0];
            String mutationScoreStr = mutationResult[22].replaceAll("\\s+","").substring(4).split("%")[0];

            //Dissect the results of test smell detection tool into a more manageable result
            HashMap<String,Integer> smells = getSmells(testSmellResult);

            //Individual Metric scores
            Integer lineCoverageScore = Integer.parseInt(lineCoverageStr);
            Integer mutationScore = Integer.parseInt(mutationScoreStr);
            Integer effectiveTestSmellScore = calculateTestSmellScore(HarmType.Effectiveness, smells);
            Integer stabilityTestSmellScore = calculateTestSmellScore(HarmType.Stability, smells);

            //Three subcategories scores
            Integer completenessScore = lineCoverageScore;
            Integer effectivenessScore = (mutationScore + effectiveTestSmellScore + lineCoverageScore) / 3;
            Integer maintainabilityScore = stabilityTestSmellScore;

            //Final Score
            int overallQualityScore = (completenessScore + effectivenessScore + maintainabilityScore) / 3;

            System.out.println("ATSQA:");
            System.out.println("Overall Quality: " + overallQualityScore);
            System.out.println();
            System.out.println("Completeness: " + completenessScore);
            System.out.println("Effectiveness: " + effectivenessScore);
            System.out.println("Maintainability: " + maintainabilityScore);
            System.out.println();

            System.out.println("Individual Metric scores: ");
            System.out.println("Code coverage: " + lineCoverageScore);
            System.out.println("Mutation score: " + mutationScore);
            System.out.println("Effective test smell score: " + effectiveTestSmellScore);
            System.out.println("Stability test smell score: " + stabilityTestSmellScore);

        }
    }

    public static HashMap<String,Integer> getSmells(String[] testSmellResult) {
        HashMap<String,Integer> smells = new HashMap<>();
        //Extract amount of test smells
        ArrayList<String> headersArray = new ArrayList<>(Arrays.asList(testSmellResult[0].split(";")));
        List<String> headers = headersArray.subList(3,headersArray.size());
        for(int k = 1; k < testSmellResult.length; k++) {
            ArrayList<String> valueArray = new ArrayList<>(Arrays.asList(testSmellResult[k].split(";")));
            List<String> values = valueArray.subList(3,valueArray.size());
            for(int i=0; i < headers.size(); i++) {
                //Initialize variables if it is first time
                if(k ==1) {
                    smells.put(headers.get(i), Integer.parseInt(values.get(i)));
                } else {
                    smells.put(headers.get(i),smells.get(headers.get(i)) + Integer.parseInt(values.get(i)));
                }
            }
        }
        return smells;
    }

    public static Integer calculateTestSmellScore(HarmType harmType, HashMap<String,Integer> smells) {
        double score = 100.0;
        for(TestSmell testSmell : TestSmell.values()) {
            score -= TSHarm.getSmellHarm(harmType,testSmell,smells);
        }
        return (int) score;
    }
}
