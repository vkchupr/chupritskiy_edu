package com.education.task1_2;


import java.util.ArrayList;

public class CommonPartTester {

    public TestResult performTestCommonPrefixTask1(CommonPartFinder finder, Scenario sc) {
        int[] vars = sc.getVars();

        String[] array = ArrayOfStringGenerator.generateTask1Array(sc);
        String realPrefix = ArrayOfStringGenerator.getPrefix();

        long startTime = System.nanoTime();
        String maxLengthCommonPart = finder.getMaxLengthCommonPrefix(array);
        long allTime = System.nanoTime() - startTime;

        boolean equals = realPrefix.equals(maxLengthCommonPart);
        return new TestResult(allTime, vars, equals);
    }

    public TestResult getTestResultScenarioTask1(CommonPartFinder finder, Scenario sc, int times) {
        ArrayList<TestResult> results = new ArrayList<TestResult>();
        for (int i = 0; i < times; i++) {
            results.add(performTestCommonPrefixTask1(finder, sc));
        }
        return calculateResult(results, sc);
    }

    public TestResult performTestCommonPrefixTask2(CommonPartFinder finder, Scenario sc) {
        int[] vars = sc.getVars();

        String[] array = ArrayOfStringGenerator.generateTask2Array(sc);
        String realPrefix = ArrayOfStringGenerator.getPrefix();

        long startTime = System.nanoTime();
        String maxLengthCommonPart = finder.getMaxLengthCommonPart(array);
        long allTime = System.nanoTime() - startTime;

        boolean equals = realPrefix.equals(maxLengthCommonPart);
        return new TestResult(allTime, vars, equals);
    }

    public TestResult getTestResultScenarioTask2(CommonPartFinder finder, Scenario sc, int times) {
        ArrayList<TestResult> results = new ArrayList<TestResult>();
        for (int i = 0; i < times; i++) {
            results.add(performTestCommonPrefixTask2(finder, sc));
        }
        return calculateResult(results, sc);
    }

    private TestResult calculateResult(ArrayList<TestResult> results, Scenario sc) {
        long sumTime = 0;
        boolean isPasses = true;
        for (TestResult result : results) {
            sumTime += result.getTime();
            isPasses = result.isResult();
        }
        long time = sumTime / results.size();
        return new TestResult(time, sc.getVars(), isPasses);
    }

}
