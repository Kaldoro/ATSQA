# ATSQA

ATSQA, stands for Actionable Test Suite Quality Assessment. 
It is a tool developed to analyze the quality of your test suite, and point out areas of improvement. 
The final score given will be between 0 and 100. 
Before you run this tool you first need two run two different tools, and extract the output.
For the specific areas of improvement open the results of the tools, for the quality rating run ATSQA and look at the results. 

The next headers show the tools you will need alongside ATSQA in order to get the results.

## PITest (The mutation testing tool)
You will need to install this tool, run it and move the output file to the ATSQA folder, 
replace the current index.html with the new file which has been generated.
### Links
https://github.com/hcoles/pitest
https://pitest.org/java_mutation_testing_systems/

## JNose (Test smell detection tool)
Install the tool, and run it.
The next step is to go the local adress were you can analyze your project by providing a github link.
Analyze the project "By TestClass", open the results export them to csv file, and rename the file to:
"result_byclasstest_testsmells.csv"
The name should already be close to that you just need to remove the name of your project from the file name.

### Links
https://github.com/arieslab/jnose

## Final steps
Install ATSQA run it, and review the results 
