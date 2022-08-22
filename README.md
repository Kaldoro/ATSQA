# ATSQA

ATSQA, stands for Actionable Test Suite Quality Assessment. 
It is a tool developed to analyze the quality of your test suite, and point out areas of improvement.
You will first need to run a few different tools before running this one.
For the specific areas of improvement open the results of the tools, for the quality rating run ATSQA.
Recommended thresholds to keep the values above:
Completeness: 95%
Effectiveness: 90%
Maintainability: 90%


## PITest (The mutation testing tool)
You will need to install this tool, run it and move the output file to the ATSQA folder, 
and replace the current index.html with the new file which has been generated.
### Links
https://github.com/hcoles/pitest
https://pitest.org/java_mutation_testing_systems/

## JNose (Test smell detection tool)
Install the tool, and run it.
The next step is to go the local adress were you can analyze your project by providing a github link.
Analyze the project "By TestClass", open the results export them to csv file, and rename the file to:
"testsmells_result.csv"
The name should already be close to that you just need to remove the name of your project from the file name.
### Links
https://github.com/arieslab/jnose
