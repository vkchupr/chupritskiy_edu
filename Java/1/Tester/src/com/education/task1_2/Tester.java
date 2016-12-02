package com.education.task1_2;

public class Tester {
    public static void main(String[] args) {
        CommonPartTester tester = new CommonPartTester();
        Scenario scenario = new Scenario(20, 1000, 40, 20);
        CommonPartFinder finder = new CommonPartFinderImpl();
        TestResult testResultScenario = tester.performTestCommonPrefixTask2(finder, scenario);
        System.out.println(testResultScenario);

//        String[] strings = ArrayOfStringGenerator.generateTask2Array(new Scenario(3, 10, 50, 50));
//        for (String string : strings) {
//            System.out.println(string);
//        }

//        String[] strings2 = ArrayOfStringGenerator.generateTask1Array(new Scenario(3, 10, 50, 50));
//        for (String string : strings2) {
//            System.out.println(string);
//        }
    }
}
